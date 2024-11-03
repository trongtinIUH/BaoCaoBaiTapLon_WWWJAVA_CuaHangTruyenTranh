package iuh.fit.cuahangtruyentranh_be.repositories;

import iuh.fit.cuahangtruyentranh_be.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findByOrderId(int orderId);
}