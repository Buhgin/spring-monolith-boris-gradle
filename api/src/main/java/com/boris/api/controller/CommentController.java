package com.boris.api.controller;

import com.boris.api.model.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.boris.business.model.dto.CommentDto;
import org.boris.business.model.enums.sort.CommentSort;
import org.boris.business.model.enums.sort.SortType;
import org.boris.business.model.request.CommentCreateRequest;
import org.boris.business.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RequestMapping("/${api.version}/comments")
@RestController
@RequiredArgsConstructor
@Tag(name = "Comment", description = "Comment related resource")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/posts/{postId}/comments/users{userId}")
    @Operation(summary = "Create comment", description = "Creating comment and unique identifier assigning. Follows model's " +
            "constraints to avoid unhandled errors")
    @ApiResponse(responseCode = "201", description = "Comment created and will be returned with id", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommentDto.class))})
    @ApiResponse(responseCode = "409", description = "Comment is already exists", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorResponse.class))})     public ResponseEntity<CommentDto> create(@PathVariable(value = "postId") Long postId
            , @PathVariable(value = "userId") Long userId
            , @RequestBody CommentCreateRequest commentCreateRequest) {
        CommentDto commentDTOcreate = commentService.createComment(commentCreateRequest, postId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentDTOcreate);
    }

    @PutMapping("/comment/{commentId}")
    @Operation(summary = "Update comment", description = "Updating comment and unique identifier assigning. Follows model's " +
            "constraints to avoid unhandled errors")
    @ApiResponse(responseCode = "200", description = "Comment updated", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommentDto.class))})
   @ApiResponse(responseCode = "404", description = "Comment not found", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorResponse.class))})
    public CommentDto update(@PathVariable(value = "commentId") Long commentId,
                                       @Valid @RequestBody CommentCreateRequest commentCreateRequest) {
        return commentService.updateComment(commentId, commentCreateRequest);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete comment", description = "Deleting comment by id")
    @ApiResponse(responseCode = "204", description = "Comment deleted", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommentDto.class))})
    @ApiResponse(responseCode = "404", description = "Comment not found", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorResponse.class))})
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/post/{id}/comments")
    @Operation(summary = "Get all comments", description = "Getting all comments by page and quantity")
@ApiResponse(responseCode = "200", description = "Comments found", content = {
        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommentDto.class))})
@ApiResponse(responseCode = "404", description = "Comments not found", content = {
        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorResponse.class))})
    public Set<CommentDto> getAllByPage(@PathVariable(name = "id") Long postId,
                                        @RequestParam(defaultValue = "0") @PositiveOrZero Integer page,
                                        @RequestParam(defaultValue = "10") @Positive Integer quantity,
                                        @RequestParam(defaultValue = "ID") CommentSort companySortBy,
                                        @RequestParam(defaultValue = "ASC") SortType sortType) {
        return commentService.getCommentsByPostId(postId, page, quantity, sortType, companySortBy);
    }

    @GetMapping("/user/{userId}/comments")
    @Operation(summary = "Get all comments", description = "Getting all comments by page and quantity")
    @ApiResponse(responseCode = "200", description = "Comments found", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CommentDto.class))})
    @ApiResponse(responseCode = "404", description = "Comments not found", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorResponse.class))})
    public Set<CommentDto> getAllByPageUserId(@PathVariable(name = "userId") Long userId,
                                              @RequestParam(defaultValue = "0") @PositiveOrZero Integer page,
                                              @RequestParam(defaultValue = "10") @Positive Integer quantity,
                                              @RequestParam(defaultValue = "ID") CommentSort companySortBy,
                                              @RequestParam(defaultValue = "ASC") SortType sortType){
        return commentService.getCommentByUserid(userId, page, quantity, sortType, companySortBy);
    }
}

