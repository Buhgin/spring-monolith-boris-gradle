package org.boris.business.mapper.dto;

import com.boris.dao.entity.User;
import org.boris.business.mapper.config.DtoMapper;
import org.boris.business.mapper.config.MapstructConfig;
import org.boris.business.model.dto.AuthDetailsDto;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfig.class)
public interface AuthDetailsMapper extends DtoMapper<AuthDetailsDto, User> {
}
