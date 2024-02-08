package com.laba.solvd.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laba.solvd.api.domain.Comment;
import com.laba.solvd.api.domain.Post;
import com.laba.solvd.api.request.*;
import org.testng.annotations.Test;

public class PostTest {
    @Test
    public void verifyGetPostByIdTest() {
        long id = 1;

        Post post = new Post();
        post.setId(id);
        post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        post.setBody("quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto");

        GetPostById getPostById = new GetPostById(id);
        getPostById.addProperty("post", post);
        getPostById.callAPI();
        getPostById.validateResponse();
    }

    @Test
    public void verifyGetCommentsByPostId() {
        long id = 1;
        Comment comment = new Comment();
        comment.setPostId(id);
        Comment[] data = new Comment[5];

        GetCommentsByPostId getCommentsByPostId = new GetCommentsByPostId(1);
        getCommentsByPostId.addProperty("comment", comment);
        getCommentsByPostId.addProperty("data", data);
        getCommentsByPostId.callAPI();
        getCommentsByPostId.validateResponse();
    }

    @Test
    public void verifyCreatePostTest() {
        Post post = new Post();
        post.setTitle("some title");
        post.setBody("some body");

        CreatePost createPost = new CreatePost();
        createPost.addProperty("post", post);
        createPost.addProperty("userId", 1);
        createPost.callAPI();
        createPost.validateResponse();
    }

    @Test
    public void verifyUpdatePostTitleById() {
        long id = 1;

        UpdatePostTitleById updatePostTitleById = new UpdatePostTitleById(id);
        updatePostTitleById.addProperty("newTitle", "new title");
        updatePostTitleById.addProperty("id", id);
        updatePostTitleById.callAPI();
        updatePostTitleById.validateResponse();
    }

    @Test
    public void verifyUpdatePostById() {
        long id = 1;
        long userId = 2;

        Post post = new Post();
        post.setId(id);
        post.setTitle("one new title");
        post.setBody("new body");

        UpdatePostById updatePostById = new UpdatePostById(id);
        updatePostById.addProperty("post", post);
        updatePostById.addProperty("userId", userId);
        updatePostById.callAPI();
        updatePostById.validateResponse();
    }

    @Test
    public void verifyDeletePostById() {
        long id = 1;
        DeletePostById deletePostById = new DeletePostById(id);
        deletePostById.callAPI();
    }

    @Test
    public void getPostTitleByPostId() {
        long id = 1;
        GetPostById getPostById = new GetPostById(id);
        String getPostByIdResponse = getPostById.callAPIExpectSuccess().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(getPostByIdResponse);
            if (jsonNode.has("title")) {
                String titleValue = jsonNode.get("title").asText();
                System.out.println(String.format("Title of the post %d is: " + titleValue, id));
            } else {
                System.out.println("Title not found");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
