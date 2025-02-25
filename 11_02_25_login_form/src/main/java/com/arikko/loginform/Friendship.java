package com.arikko.loginform;

public class Friendship {
    private String username;
    private String friendUsername;

    public Friendship() {
    }

    public Friendship(String username, String friend_username) {
        this.username = username;
        this.friendUsername = friend_username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFriendUsername() {
        return friendUsername;
    }

    public void setFriendUsername(String friendUsername) {
        this.friendUsername = friendUsername;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "username='" + username + '\'' +
                ", friend_username='" + friendUsername + '\'' +
                '}';
    }
}
