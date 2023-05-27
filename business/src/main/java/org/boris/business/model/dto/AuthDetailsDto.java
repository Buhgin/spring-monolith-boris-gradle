package org.boris.business.model.dto;

import com.boris.dao.entity.Role;

import java.util.Set;

public record AuthDetailsDto(String email, String password, Set<Role> roles) {
}
