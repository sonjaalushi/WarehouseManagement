//package com.WarehouseManagement.mapper;
//
//import com.WarehouseManagement.dto.OrderDTO;
//import com.WarehouseManagement.entity.Orders;
//import com.WarehouseManagement.repository.OrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.processing.Generated;
//import java.util.stream.Collectors;
//
//@Generated(
//        value = "org.mapstruct.ap.MappingProcessor"
//
//)
//@Component
//public class OrderEntityToOrderDTOimpl implements OrderEntityToOrderDTO {
//
//    @Autowired
//    OrderRepository orderRepository;
//    @Override
//    public OrderDTO ordersToOrdersDto(Orders orders) {
//
//        if (orders == null) {
//            return null;
//        }
//
//        OrderDTO orderDTO = new OrderDTO();
//
//        orderDTO.setOrderNumber(orders.getOrderNumber());
//        orderDTO.setOrderStatus(orders.getOrderStatus());
//        orderDTO.setDeadlineDate(orders.getDeadlineDate());
//        orderDTO.setSubmittedDate(orders.getSubmittedDate());
//
//        return orderDTO;
//
//
//    }
//
////    public Page<OrderDTO> findAll(Pageable p) {
////        Page<Orders> page = orderRepository.findAll(p); // Page<User>
////        return new PageImpl<OrderDTO>(UserConverter.convert(page.getContent()), p, page.getTotalElements());
////    }
////
//
//
////    public Page<OrderDTO> findAll(Pageable pageable) {
////        Page<Orders> ordersPage = orderRepository.findAll(pageable);
////        return new PageImpl<OrderDTO>(ordersPage.getContent()
////                .stream()
////                .map(orders -> new OrderDTO(
////                        orders.getOrderNumber(),
////                        orders.getOrderStatus(),
////                        orders.getDeadlineDate(),
////                        orders.getSubmittedDate(),
////                        orders.getPresentPosition()))
////                .collect(Collectors.toList()), pageable, totalElements);
////    }
//}
