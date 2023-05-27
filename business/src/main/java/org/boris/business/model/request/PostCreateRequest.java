package org.boris.business.model.request;

import com.boris.dao.entity.Comment;
import com.boris.dao.entity.User;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
public class PostCreateRequest {
    private String title;
    private String description;
    private String content;

}
