package org.boris.business.mapper.dto;

import com.boris.dao.entity.Role;
import org.boris.business.mapper.config.DtoMapper;
import org.boris.business.mapper.config.MapstructConfig;
import org.boris.business.model.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfig.class)
public interface RoleMapper extends DtoMapper<RoleDto, Role> {
}
