package iuh.fit.cuahangtruyentranh_be.services.impl;

import iuh.fit.cuahangtruyentranh_be.dtos.CartDTO;
import iuh.fit.cuahangtruyentranh_be.models.Cart;

import java.util.List;

public interface CartServices {
    List<Cart> saveAll(int customerId, List<Cart> carts);
    List<CartDTO> getCartByCustomerId(int customerId);
}
