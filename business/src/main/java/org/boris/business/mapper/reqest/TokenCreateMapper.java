package org.boris.business.mapper.reqest;

import com.boris.dao.entity.Token;
import org.boris.business.mapper.config.EntityMapper;
import org.boris.business.mapper.config.MapstructConfig;
import org.boris.business.model.request.TokenCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(config = MapstructConfig.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TokenCreateMapper extends EntityMapper<Token, TokenCreateRequest> {
    @Override
    Token toEntity(TokenCreateRequest dto);
}
