package org.boris.business.mapper.reqest;

import com.boris.dao.entity.User;
import org.boris.business.mapper.config.EntityMapper;
import org.boris.business.mapper.config.MapstructConfig;
import org.boris.business.model.request.RegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(config = MapstructConfig.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthenticationCreateMapper extends EntityMapper<User, RegistrationRequest> {
    @Override
    User toEntity(RegistrationRequest dto);

    @Override
    Set<User> toEntitySet(Set<RegistrationRequest> dtoSet);
}
