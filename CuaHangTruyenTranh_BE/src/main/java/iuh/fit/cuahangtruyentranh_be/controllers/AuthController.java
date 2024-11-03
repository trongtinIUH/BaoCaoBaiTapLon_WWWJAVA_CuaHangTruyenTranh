package iuh.fit.cuahangtruyentranh_be.controllers;

import iuh.fit.cuahangtruyentranh_be.models.Customer;
import iuh.fit.cuahangtruyentranh_be.services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthServices authServices;

    @PostMapping("/login")
    public Customer login(@RequestBody Customer customer) {
        return authServices.login(customer.getEmail(), customer.getPassword());
    }

    @PostMapping("/signup")
    public ResponseEntity<Customer> signup(@RequestBody Customer customer) {
        Customer createdCustomer = authServices.signup(customer.getName(), customer.getEmail(), customer.getPassword(), customer.getRole());
        return ResponseEntity.ok(createdCustomer);
    }
}