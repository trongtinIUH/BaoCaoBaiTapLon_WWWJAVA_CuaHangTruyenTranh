package iuh.fit.cuahangtruyentranh_be.controllers;

import iuh.fit.cuahangtruyentranh_be.dtos.CartDTO;
import iuh.fit.cuahangtruyentranh_be.models.Cart;
import iuh.fit.cuahangtruyentranh_be.services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@CrossOrigin(origins = "http://localhost:5173")
public class CartController {

    @Autowired
    private CartServices cartService;

    @PostMapping("/save/{customerId}")
    public ResponseEntity<List<Cart>> saveCarts(@PathVariable int customerId, @RequestBody List<Cart> carts) {
        List<Cart> savedCarts = cartService.saveAll(customerId, carts);
        return ResponseEntity.ok(savedCarts);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<CartDTO>> getCartByCustomerId(@PathVariable int customerId) {
        List<CartDTO> carts = cartService.getCartByCustomerId(customerId);
        return ResponseEntity.ok(carts);
    }
}
