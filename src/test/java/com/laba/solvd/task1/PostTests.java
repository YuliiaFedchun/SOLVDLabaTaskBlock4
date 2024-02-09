package com.laba.solvd.task1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laba.solvd.task1.api.*;
import com.laba.solvd.task1.domain.Comment;
import com.laba.solvd.task1.domain.Post;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class PostTests {
    private static final Logger LOGGER = Logger.getLogger(PostTests.class);

    @Test
    public void verifyGetPostByIdTest() {
        long id = 1;

        GetPostByIdMethod getPostById = new GetPostByIdMethod(id);
        getPostById.addProperty("postId", id);
        getPostById.callAPIExpectSuccess();
        getPostById.validateResponse();
    }

    @Test
    public void verifyGetCommentsByPostIdTest() {
        long id = 1;
        Comment comment = new Comment();
        comment.setPostId(id);
        Comment[] data = new Comment[5];

        GetCommentsByPostIdMethod getCommentsByPostId = new GetCommentsByPostIdMethod(1);
        getCommentsByPostId.addProperty("comment", comment);
        getCommentsByPostId.addProperty("data", data);
        getCommentsByPostId.callAPIExpectSuccess();
        getCommentsByPostId.validateResponse();
    }

    @Test
    public void verifyCreatePostTest() {
        Post post = new Post();
        post.setTitle("some title");
        post.setBody("some body");

        CreatePostMethod createPost = new CreatePostMethod();
        createPost.addProperty("post", post);
        createPost.addProperty("userId", 1);
        createPost.callAPIExpectSuccess();
        createPost.validateResponse();
    }

    @Test
    public void verifyUpdatePostTitleByIdTest() {
        long id = 1;

        UpdatePostTitleByIdMethod updatePostTitleById = new UpdatePostTitleByIdMethod(id);
        updatePostTitleById.addProperty("newTitle", "new title");
        updatePostTitleById.addProperty("id", id);
        updatePostTitleById.callAPIExpectSuccess();
        updatePostTitleById.validateResponse();
    }

    @Test
    public void verifyUpdatePostByIdTest() {
        long id = 1;
        long userId = 2;

        Post post = new Post();
        post.setId(id);
        post.setTitle("one new title");
        post.setBody("new body");

        UpdatePostByIdMethod updatePostById = new UpdatePostByIdMethod(id);
        updatePostById.addProperty("post", post);
        updatePostById.addProperty("userId", userId);
        updatePostById.callAPIExpectSuccess();
        updatePostById.validateResponse();
    }

    @Test
    public void verifyDeletePostByIdTest() {
        long id = 1;
        DeletePostByIdMethod deletePostById = new DeletePostByIdMethod(id);
        deletePostById.callAPIExpectSuccess();
    }

    @Test
    public void getPostTitleByPostIdTest() {
        long id = 1;
        GetPostByIdMethod getPostById = new GetPostByIdMethod(id);
        String getPostByIdResponse = getPostById.callAPIExpectSuccess().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(getPostByIdResponse);
            if (jsonNode.has("title")) {
                String titleValue = jsonNode.get("title").asText();
                LOGGER.info(String.format("Title of the post %d is: " + titleValue, id));
            } else {
                LOGGER.warn("Title not found");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
