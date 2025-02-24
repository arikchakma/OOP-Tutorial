package com.arikko.loginform;

import java.time.LocalDate;
import java.util.ArrayList;

public class Post {
    private int id;
    private String username, content;
    private LocalDate createdAt;
    private ArrayList<User> likes;

    public Post() {
    }

    public Post(int id, String username, String content, LocalDate createdAt, ArrayList<User> likes) {
        this.id = id;
        this.username = username;
        this.content = content;
        this.createdAt = createdAt;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<User> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<User> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", likes=" + likes +
                '}';
    }
}
