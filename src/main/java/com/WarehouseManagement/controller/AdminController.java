package com.WarehouseManagement.controller;

import com.WarehouseManagement.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AdminController {

    public User createUser(@RequestBody User user);


    public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable Long id);

    public ResponseEntity<List<User>> getUsers();

    public ResponseEntity<String> deleteUser(@PathVariable Long id);
}
