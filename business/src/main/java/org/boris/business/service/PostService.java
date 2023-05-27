package org.boris.business.service;

import com.boris.dao.entity.Post;
import com.boris.dao.entity.User;
import com.boris.dao.repository.PostRepository;
import com.boris.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.boris.business.exeption.ResourceNotFoundException;
import org.boris.business.mapper.dto.PostMapper;
import org.boris.business.mapper.reqest.PostCreateMapper;
import org.boris.business.model.dto.PostDto;
import org.boris.business.model.enums.sort.PostSort;
import org.boris.business.model.enums.sort.SortType;
import org.boris.business.model.request.PostCreateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostCreateMapper postCreateMapper;
    private final PostMapper postMapper;
    private final UserRepository userRepository;


    public PostDto create(PostCreateRequest postCreateRequest, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", userId));
        Post post = postCreateMapper.toEntity(postCreateRequest);
        post.setUser(user);
        postRepository.save(post);
        return postMapper.toDto(post);
    }

    public PostDto update(Long id, PostCreateRequest postCreateRequest) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post", "id", id));
        Post newPost = postCreateMapper.toEntity(postCreateRequest);
        newPost.setId(post.getId());
        newPost.setUser(post.getUser());
        Post updatedPost = postRepository.save(newPost);
        return postMapper.toDto(updatedPost);
    }

    public void deleteById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    public Set<PostDto> getAll(int pageNo, int pageSize, SortType sortType, PostSort postSort) {
        Sort sort = Sort.by(sortType.getDirection(), postSort.getAttribute());
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> posts = postRepository.findAll(pageable);
        Set<Post> postDtoSet = posts.toSet();

        return postMapper.toDtoSet(postDtoSet);
    }

    public Set<PostDto> getByUserId(Long userid,
                                    int pageNo,
                                    int pageSize,
                                    SortType sortType,
                                    PostSort postSort) {
        User user = userRepository.findById(userid).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", userid));
        Sort sort = Sort.by(sortType.getDirection(), postSort.getAttribute());
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Post> posts = postRepository.findByUserId(user.getId(), pageable);
        Set<Post> postSet = posts.toSet();
        return postMapper.toDtoSet(postSet);
    }

    public PostDto getOne(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post", "id", id));
        return postMapper.toDto(post);
    }
}
