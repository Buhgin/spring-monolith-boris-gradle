package org.boris.business.mapper.reqest;

import com.boris.dao.entity.Comment;
import jakarta.persistence.EntityManager;
import org.boris.business.mapper.config.EntityMapper;
import org.boris.business.mapper.config.MapstructConfig;
import org.boris.business.model.request.CommentCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public interface CommentCreateMapper extends EntityMapper<Comment, CommentCreateRequest> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "post",ignore = true)
    @Mapping(target = "user",ignore = true)
    Comment toEntity(CommentCreateRequest dto);
}
