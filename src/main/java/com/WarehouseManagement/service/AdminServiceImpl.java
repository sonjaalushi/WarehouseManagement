package com.WarehouseManagement.service;

import com.WarehouseManagement.entity.User;
import com.WarehouseManagement.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public User createUser(User user) {
        return adminRepository.save(user);
    }

    @Override
    public User updateUserById(User user, Long id) {
        return adminRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return adminRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }


}
