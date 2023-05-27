package org.boris.business.service;

import com.boris.dao.entity.Comment;
import com.boris.dao.entity.Post;
import com.boris.dao.entity.User;
import com.boris.dao.repository.CommentRepository;
import com.boris.dao.repository.PostRepository;
import com.boris.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.boris.business.exeption.ResourceNotFoundException;
import org.boris.business.mapper.dto.CommentMapper;
import org.boris.business.mapper.reqest.CommentCreateMapper;
import org.boris.business.model.dto.CommentDto;
import org.boris.business.model.enums.sort.CommentSort;

import org.boris.business.model.enums.sort.SortType;
import org.boris.business.model.request.CommentCreateRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentCreateMapper commentCreateMapper;
    private final CommentMapper commentMapper;
    private final UserRepository userRepository;
    private final PostRepository postRepository;


    public CommentDto createComment(CommentCreateRequest commentCreateRequest, Long postId, Long userId) {
        Post post = postRepository.findById(postId).orElseThrow(() ->
                new ResourceNotFoundException("Post", "id", postId));
        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User","id",userId));
        Comment comment = commentCreateMapper.toEntity(commentCreateRequest);
        comment.setPost(post);
        comment.setUser(user);
        Comment newComment = commentRepository.save(comment);
        return commentMapper.toDto(newComment);
    }
    public CommentDto updateComment(Long commentId,CommentCreateRequest commentCreateRequest)  {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFoundException("Comment", "id", commentId));
       Comment  newComment = commentCreateMapper.toEntity(commentCreateRequest);
       newComment.setPost(comment.getPost());
       newComment.setUser(comment.getUser());
         Comment commentSave = commentRepository.save(comment);
        return commentMapper.toDto(commentSave);
    }

    public void deleteComment(Long id) {
        commentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Comment", "id", id));
        commentRepository.deleteById(id);
    }
    public Set<CommentDto> getCommentByUserid(Long userId, int pageNo, int pageSize, SortType sortType, CommentSort commentSort) {
        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User","id",userId));
        Sort sort = Sort.by(sortType.getDirection(),commentSort.getAttribute());
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<Comment> comments =  commentRepository.findByUserId(user.getId(),pageable);
        Set<Comment> commentSet = comments.toSet();
        return commentMapper.toDtoSet(commentSet);
    }
    public Set<CommentDto> getCommentsByPostId(Long postId, int pageNo, int pageSize, SortType sortType, CommentSort commentSort) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        Sort sort= Sort.by(sortType.getDirection(),commentSort.getAttribute());
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Comment> comemnts = commentRepository.findByPostId(post.getId(),pageable);
        Set<Comment> commentSet =comemnts.toSet();
        return commentMapper.toDtoSet(commentSet);
    }
}
