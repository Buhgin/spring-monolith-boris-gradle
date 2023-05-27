package org.boris.business.model.request;

import com.boris.dao.entity.User;
import lombok.Data;
import org.boris.business.model.dto.AuthDetailsDto;

@Data
public class TokenCreateRequest {
    private String token;
    private AuthDetailsDto authDetailsDto;
}
