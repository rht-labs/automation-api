package com.rhc.automation.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rhc.automation.model.Role;
import com.rhc.automation.model.User;

public interface CustomerService {

    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long userId);
    User getUser(Long userId);
    Page<User> getUsers(Pageable page);
    Iterable<Role> getRoles();
}
