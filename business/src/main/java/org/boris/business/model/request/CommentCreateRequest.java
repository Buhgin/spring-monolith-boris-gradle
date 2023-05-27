package org.boris.business.model.request;

import com.boris.dao.entity.Post;
import com.boris.dao.entity.User;
import lombok.Data;

@Data
public class CommentCreateRequest {
    private String name;

    private String email;

    private String body;

}
