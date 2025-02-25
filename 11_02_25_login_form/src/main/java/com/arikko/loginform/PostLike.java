package com.arikko.loginform;

public class PostLike {
    private int postId;
    private String likedByUsername;


    public PostLike() {
    }

    public PostLike(int postId, String likedByUsername) {
        this.postId = postId;
        this.likedByUsername = likedByUsername;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getLikedByUsername() {
        return likedByUsername;
    }

    public void setLikedByUsername(String likedByUsername) {
        this.likedByUsername = likedByUsername;
    }

    @Override
    public String toString() {
        return "PostLike{" +
                "postId=" + postId +
                ", likedByUsername='" + likedByUsername + '\'' +
                '}';
    }
}
