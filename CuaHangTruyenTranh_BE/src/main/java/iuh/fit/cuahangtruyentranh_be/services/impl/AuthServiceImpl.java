package iuh.fit.cuahangtruyentranh_be.services.impl;

import iuh.fit.cuahangtruyentranh_be.dtos.CustomerDTO;
import iuh.fit.cuahangtruyentranh_be.enums.Role;
import iuh.fit.cuahangtruyentranh_be.models.Customer;
import iuh.fit.cuahangtruyentranh_be.repositories.CustomerRepository;
import iuh.fit.cuahangtruyentranh_be.services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthServiceImpl implements AuthServices {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer login(String email, String password) {
        return customerRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password"));
    }

    @Override
    public Customer signup(String name, String email, String password, Role role) {
        Customer customer = new Customer(name, email, null, null, password, role);
        customer = customerRepository.save(customer);
        return customer;
    }

    private CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setAvatar(customer.getAvatar());
        dto.setAddress(customer.getAddress());
        return dto;
    }
}