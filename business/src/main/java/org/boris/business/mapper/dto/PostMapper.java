package org.boris.business.mapper.dto;

import com.boris.dao.entity.Post;
import org.boris.business.mapper.config.DtoMapper;
import org.boris.business.mapper.config.MapstructConfig;
import org.boris.business.model.dto.PostDto;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfig.class)
public interface PostMapper extends DtoMapper<PostDto, Post> {
}
