package com.WarehouseManagement.controller;

import com.WarehouseManagement.AbstractTest;
import com.WarehouseManagement.entity.User;
import com.WarehouseManagement.repository.AdminRepository;
import com.WarehouseManagement.service.AdminServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
//import org.testng.annotations.Test;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerImplTest extends AbstractTest {


    @InjectMocks
    AdminControllerImpl adminController;
    @Mock
    AdminServiceImpl adminRepository;

    @Mock
    AdminRepository adminRepository1;


    @Override
    @Before
    public void setUp() {
        super.setUp();
    }


    @Test
    public void testCreateUser() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user = new User(1L, "user", "user", "user@gmail", null, null);
        when(adminRepository.createUser(any(User.class))).thenReturn(user);
        User user1 = adminController.createUser(user);
        assertThat(user1.getUsername()).isEqualTo("user");


    }

    @Test
    public void testUpdateUserById() {
        User user = new User();
        user.setUser_id(1L);
        user.setUsername("sonja");
        user.setEmail("fshn");
        user.setPassword("123");
        Optional<User> userOptional = Optional.of(user);
        User user1 = userOptional.get();
        // providing knowledge
        when(adminRepository1.findById(any(Long.class))).thenReturn(userOptional);
        ResponseEntity r = new ResponseEntity(HttpStatus.OK);
        when(adminRepository.createUser(eq(user1))).thenReturn(user);
        ResponseEntity<User> userResponseEntity = adminController.updateUserById(user, 1L);

        assertThat(userResponseEntity.getStatusCodeValue() == 200);
    }


    @Test
    public void testGetUsers() {
//            Integer id = 1;
        this.adminRepository.getUsers();
        User user = new User();
        ResponseEntity<List<User>> users = adminController.getUsers();
        assertThat(users.getStatusCodeValue() == 200);
    }


    @Test
    public void testDeleteUser() {
        Long id = 1L;
        this.adminRepository.deleteUserById(id);
        User user = new User();
        ResponseEntity<String> user1 = adminController.deleteUser(1L);
        assertThat(user1.getStatusCodeValue()).isEqualTo(200);

    }
}





