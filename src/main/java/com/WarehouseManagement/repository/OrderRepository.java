package com.WarehouseManagement.repository;


import com.WarehouseManagement.dto.OrderDTO;
import com.WarehouseManagement.entity.OrderStatus;
import com.WarehouseManagement.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
//    List<Order> findAllByUserOrderByCreatedDateDesc(User user);

    @Query(value = "SELECT * FROM management.order_table WHERE order_status = :orderStatus", nativeQuery = true)
    List<Orders> filterByStatus(Integer orderStatus);


//    @Query(value = "SELECT o.order_number as orderNumber, o.order_status as orderStatus,o.submitted_date as submittedDate,o.deadline_date as deadlineDate FROM Orders o WHERE order_status = :orderStatus", nativeQuery = true)
//    List<Orders> findAllOrders(String orderStatus);


//    @NamedNativeQuery(name = "ChessPlayer.findPlayerNameDtoById_Named",
//            query = "SELECT p.first_name as first, p.last_name as last FROM Chess_Player p WHERE id = :id",
//            resultSetMapping = "Mapping.PlayerNameDto")
//    @SqlResultSetMapping(name = "Mapping.PlayerNameDto",
//            classes = @ConstructorResult(targetClass = OrderDtoInterface.class,
//                    columns = {@ColumnResult(name = "first"),
//                            @ColumnResult(name = "last")}))


}
