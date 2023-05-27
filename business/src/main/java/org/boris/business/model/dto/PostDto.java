package org.boris.business.model.dto;

import com.boris.dao.entity.Comment;
import com.boris.dao.entity.User;

import java.util.Set;

public record PostDto(Long id,
                      String title,
                      String description,
                      String content,
                      User user) {
}
