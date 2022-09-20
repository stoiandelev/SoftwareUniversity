package com.example.spotifyplaylistapp.session;




public class UserSession {

    private Long id;
    private String username;
    private String email;

    public UserSession() {
    }

    public Long getId() {
        return id;
    }

    public UserSession setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserSession setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserSession setEmail(String email) {
        this.email = email;
        return this;
    }
}
