package org.boris.business.mapper.reqest;

import com.boris.dao.entity.Role;
import org.boris.business.mapper.config.EntityMapper;
import org.boris.business.mapper.config.MapstructConfig;
import org.boris.business.model.dto.RoleDto;
import org.boris.business.model.request.RoleCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(config = MapstructConfig.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleCreateMapper extends EntityMapper<Role, RoleCreateRequest> {
    @Override
    Role toEntity(RoleCreateRequest dto);
}
