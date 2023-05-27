package org.boris.business.mapper.reqest;

import com.boris.dao.entity.Post;
import org.boris.business.mapper.config.EntityMapper;
import org.boris.business.mapper.config.MapstructConfig;
import org.boris.business.model.request.PostCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public interface PostCreateMapper extends EntityMapper<Post, PostCreateRequest> {
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user",ignore = true)
    Post toEntity(PostCreateRequest dto);
}
