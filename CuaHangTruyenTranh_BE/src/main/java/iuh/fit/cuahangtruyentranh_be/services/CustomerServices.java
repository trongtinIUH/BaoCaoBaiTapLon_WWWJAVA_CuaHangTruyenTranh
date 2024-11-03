package iuh.fit.cuahangtruyentranh_be.services;

import iuh.fit.cuahangtruyentranh_be.dtos.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerServices {
    List<CustomerDTO> getAllCustomers();
    Optional<CustomerDTO> getCustomerById(int id);
    CustomerDTO addCustomer(CustomerDTO customerDTO, String password);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(int id);
    void updatePassword(int id, String newPassword);
}