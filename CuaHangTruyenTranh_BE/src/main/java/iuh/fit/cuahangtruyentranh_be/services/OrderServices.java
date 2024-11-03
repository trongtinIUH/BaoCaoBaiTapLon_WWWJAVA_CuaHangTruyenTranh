package iuh.fit.cuahangtruyentranh_be.services;

import iuh.fit.cuahangtruyentranh_be.dtos.OrderDTO;
import iuh.fit.cuahangtruyentranh_be.dtos.OrderDetailDTO;
import iuh.fit.cuahangtruyentranh_be.models.Order;
import iuh.fit.cuahangtruyentranh_be.models.OrderDetail;

import java.util.List;

public interface OrderServices {
    List<Order> getAllOrders();
    List<Order> getOrdersByCustomerId(int customerId);

    Order createOrder(OrderDTO orderDTO);

    void deleteAllOrders();

    void deleteOrder(int orderId);

    List<OrderDetail> getOrderDetailsByOrderId(int orderId);

    OrderDetail updateOrderDetailQuantity(int orderDetailId, int quantity);

    void deleteOrderDetail(int orderDetailId);

    OrderDetail addOrderDetailToOrder(int orderId, OrderDetailDTO orderDetailDTO);
    void deleteAllOrdersByCustomerId(int customerId);
}
