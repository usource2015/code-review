package com.example.codereview.service;

import com.example.codereview.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void addResult(User user);
    List<User> getUsers();
}
