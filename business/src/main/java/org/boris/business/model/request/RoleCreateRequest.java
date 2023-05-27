package org.boris.business.model.request;

import com.boris.dao.entity.User;
import lombok.Data;

@Data
public class RoleCreateRequest {
    private User user;
}
