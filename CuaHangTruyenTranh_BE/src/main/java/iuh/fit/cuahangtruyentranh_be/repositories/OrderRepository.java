package iuh.fit.cuahangtruyentranh_be.repositories;

import iuh.fit.cuahangtruyentranh_be.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomerId(int customerId);
}