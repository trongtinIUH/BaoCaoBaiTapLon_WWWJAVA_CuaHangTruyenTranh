package iuh.fit.cuahangtruyentranh_be.repositories;

import iuh.fit.cuahangtruyentranh_be.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByCustomerId(int customerId);
}