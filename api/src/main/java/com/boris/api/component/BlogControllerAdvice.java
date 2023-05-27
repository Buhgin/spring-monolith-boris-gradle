package com.boris.api.component;

import com.boris.api.model.ApiErrorResponse;
import com.boris.api.model.ApiResponse;
import org.boris.business.exeption.BlogApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BlogControllerAdvice {
    @ExceptionHandler(BlogApiException.class)
    private ResponseEntity<ApiErrorResponse> httpBlogApiExceptionHandler(BlogApiException exception) {
        return ApiResponse.buildErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}
