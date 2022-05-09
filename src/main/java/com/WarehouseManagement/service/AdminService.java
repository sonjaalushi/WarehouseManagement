package com.WarehouseManagement.service;

import com.WarehouseManagement.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AdminService {
    public User createUser(@RequestBody User user);

    public User updateUserById(@RequestBody User user, @PathVariable Long id);

    public List<User> getUsers();

    public void deleteUserById(@PathVariable Long id);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
