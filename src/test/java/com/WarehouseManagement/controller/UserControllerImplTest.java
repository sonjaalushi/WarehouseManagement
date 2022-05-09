package com.WarehouseManagement.controller;

import com.WarehouseManagement.AbstractTest;
import com.WarehouseManagement.entity.Orders;
import com.WarehouseManagement.entity.User;
import com.WarehouseManagement.repository.AdminRepository;
import com.WarehouseManagement.repository.OrderRepository;
import com.WarehouseManagement.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerImplTest extends AbstractTest {

    @InjectMocks
    UserControllerImpl userController;
    @Mock
    UserServiceImpl userService;

    @Mock
    OrderRepository orderRepository;

    @Mock
    AdminRepository adminRepository;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testCreateOrder() {
        Long userId = 1L;
        User user = adminRepository.getById(userId);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Orders orders = new Orders(1L, null, null, null, null, null, new User(1L));
        when(userService.createOrder(any(Orders.class))).thenReturn(orders);
        ResponseEntity<User> user1 = userController.createOrder(orders, orders.getUser().getUser_id());
        assertThat(user1.getStatusCodeValue() == 200);

    }

    public void testGetAllOrders() {
    }

    public void testUpdateOrder() {
    }

    public void testDeleteItemById() {
    }

    public void testUpdateItemQuantity() {
    }

    public void testTestDeleteItemById() {
    }

    public void testSubmitOrder() {
    }

    public void testTestSubmitOrder() {
    }
}