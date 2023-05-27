package org.boris.business.model.dto;

import com.boris.dao.entity.Post;
import com.boris.dao.entity.User;

public record CommentDto(Long id,
                         String name,

                         String email,

                         String body,

                         Post post,

                         User user) {
}
