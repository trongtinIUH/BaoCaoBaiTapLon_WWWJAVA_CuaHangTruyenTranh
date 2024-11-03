package iuh.fit.cuahangtruyentranh_be.controllers;

import iuh.fit.cuahangtruyentranh_be.dtos.OrderDTO;
import iuh.fit.cuahangtruyentranh_be.dtos.OrderDetailDTO;
import iuh.fit.cuahangtruyentranh_be.models.Order;
import iuh.fit.cuahangtruyentranh_be.models.OrderDetail;
import iuh.fit.cuahangtruyentranh_be.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderServices orderService;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable int customerId) {
        List<Order> orders = orderService.getOrdersByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        Order createdOrder = orderService.createOrder(orderDTO);
        return ResponseEntity.ok(createdOrder);
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<Void> deleteAllOrdersByCustomerId(@PathVariable int customerId) {
        orderService.deleteAllOrdersByCustomerId(customerId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAllOrders() {
        orderService.deleteAllOrders();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{orderId}/delete")
    public ResponseEntity<Void> deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{orderId}/detail")
    public ResponseEntity<List<OrderDetail>> getOrderDetailsByOrderId(@PathVariable int orderId) {
        List<OrderDetail> orderDetails = orderService.getOrderDetailsByOrderId(orderId);
        return ResponseEntity.ok(orderDetails);
    }

    @PutMapping("/detail/{orderDetailId}/update")
    public ResponseEntity<OrderDetail> updateOrderDetailQuantity(@PathVariable int orderDetailId, @RequestParam int quantity) {
        OrderDetail updatedOrderDetail = orderService.updateOrderDetailQuantity(orderDetailId, quantity);
        return ResponseEntity.ok(updatedOrderDetail);
    }

    @DeleteMapping("/detail/{orderDetailId}/delete")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable int orderDetailId) {
        orderService.deleteOrderDetail(orderDetailId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{orderId}/detail/create")
    public ResponseEntity<OrderDetail> addOrderDetailToOrder(@PathVariable int orderId, @RequestBody OrderDetailDTO orderDetailDTO) {
        OrderDetail addedOrderDetail = orderService.addOrderDetailToOrder(orderId, orderDetailDTO);
        return ResponseEntity.ok(addedOrderDetail);
    }
}
