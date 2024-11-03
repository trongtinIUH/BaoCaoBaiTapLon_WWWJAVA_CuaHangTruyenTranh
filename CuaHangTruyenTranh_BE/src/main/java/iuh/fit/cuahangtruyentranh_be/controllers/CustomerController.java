package iuh.fit.cuahangtruyentranh_be.controllers;

import iuh.fit.cuahangtruyentranh_be.dtos.CustomerDTO;
import iuh.fit.cuahangtruyentranh_be.models.Customer;
import iuh.fit.cuahangtruyentranh_be.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = customerServices.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
        Optional<CustomerDTO> customerDTO = customerServices.getCustomerById(id);
        return customerDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAvatar(customer.getAvatar());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setRole(customer.getRole());
        CustomerDTO createdCustomer = customerServices.addCustomer(customerDTO, customer.getPassword());
        return ResponseEntity.ok(createdCustomer);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable int id, @RequestBody CustomerDTO customerDTO) {
        customerDTO.setId(id);
        CustomerDTO updatedCustomer = customerServices.updateCustomer(customerDTO);
        return ResponseEntity.ok(updatedCustomer);
    }

    @PutMapping("/{id}/update/password")
    public ResponseEntity<Void> updatePassword(@PathVariable int id, @RequestBody Map<String, String> requestBody) {
        String newPassword = requestBody.get("new_password");
        if (newPassword != null) {
            customerServices.updatePassword(id, newPassword);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}