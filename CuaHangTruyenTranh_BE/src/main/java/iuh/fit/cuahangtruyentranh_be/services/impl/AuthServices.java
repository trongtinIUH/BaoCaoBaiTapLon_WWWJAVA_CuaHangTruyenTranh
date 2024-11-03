package iuh.fit.cuahangtruyentranh_be.services.impl;

import iuh.fit.cuahangtruyentranh_be.enums.Role;
import iuh.fit.cuahangtruyentranh_be.models.Customer;

public interface AuthServices {
    Customer login(String email, String password);
    Customer signup(String name, String email, String password, Role role);
}
