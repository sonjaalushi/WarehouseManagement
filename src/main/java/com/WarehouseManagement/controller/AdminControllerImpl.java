package com.WarehouseManagement.controller;

import com.WarehouseManagement.entity.User;
import com.WarehouseManagement.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminControllerImpl implements AdminController {
    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    @Autowired
    AdminServiceImpl adminService;

    @PostMapping("/createUser")
    @Override
    public User createUser(@RequestBody User user) {
        User user1 = adminService.createUser(user);
        log.info("Creating User");
        return user1;
    }


    @PostMapping("/updateUserById/{id}")
    @Override
    public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable("id") Long id) {
        user.setUser_id(id);
        log.info("Updating User by id");
        User user1 = adminService.updateUserById(user, id);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")

    @Override
    public ResponseEntity<List<User>> getUsers() {
        List<User> user = adminService.getUsers();
        log.info("Getting all users");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        log.info("Deleting user By Id");
        adminService.deleteUserById(id);
        return new ResponseEntity<String>("User deleted successfully!.", HttpStatus.OK);
    }
}
