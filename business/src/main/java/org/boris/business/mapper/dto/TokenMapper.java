package org.boris.business.mapper.dto;

import com.boris.dao.entity.Token;
import org.boris.business.mapper.config.DtoMapper;
import org.boris.business.mapper.config.MapstructConfig;
import org.boris.business.model.dto.TokenDto;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfig.class)
public interface TokenMapper {//extends DtoMapper<TokenDto, Token> {
}
