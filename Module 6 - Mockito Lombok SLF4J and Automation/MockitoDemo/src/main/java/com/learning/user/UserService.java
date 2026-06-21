package com.learning.user;

public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public String getUserName() {
        return repo.getName();
    }
}
