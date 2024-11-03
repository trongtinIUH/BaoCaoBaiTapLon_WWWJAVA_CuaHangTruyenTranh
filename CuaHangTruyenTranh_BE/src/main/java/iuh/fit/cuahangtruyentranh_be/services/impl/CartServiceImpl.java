package iuh.fit.cuahangtruyentranh_be.services.impl;

import iuh.fit.cuahangtruyentranh_be.dtos.CartDTO;
import iuh.fit.cuahangtruyentranh_be.models.Cart;
import iuh.fit.cuahangtruyentranh_be.repositories.CartRepository;
import iuh.fit.cuahangtruyentranh_be.services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartServices {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> saveAll(int customerId, List<Cart> carts) {
        // Delete all carts for the specified customer
        cartRepository.deleteAll(cartRepository.findByCustomerId(customerId));

        // Set the customerId for each cart and save them
        for (Cart cart : carts) {
            cart.setCustomerId(customerId);
        }
        return cartRepository.saveAll(carts);
    }
    @Override
    public List<CartDTO> getCartByCustomerId(int customerId) {
        List<Cart> carts = cartRepository.findByCustomerId(customerId);
        return carts.stream()
                .map(cart -> new CartDTO(
                        cart.getBookId(),
                        cart.getName(),
                        cart.getPrice(),
                        cart.getQuantity(),
                        cart.getAvailableQuantity(),
                        cart.getThumbnail()
                ))
                .collect(Collectors.toList());
    }
}
