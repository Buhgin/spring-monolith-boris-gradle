package org.boris.business.mapper.dto;

import com.boris.dao.entity.Comment;
import org.boris.business.mapper.config.DtoMapper;
import org.boris.business.mapper.config.MapstructConfig;
import org.boris.business.model.dto.CommentDto;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfig.class)
public interface CommentMapper extends DtoMapper<CommentDto, Comment> {
}
