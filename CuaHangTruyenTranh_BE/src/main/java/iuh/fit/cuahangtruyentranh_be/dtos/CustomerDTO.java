package iuh.fit.cuahangtruyentranh_be.dtos;

import iuh.fit.cuahangtruyentranh_be.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
    private String address;
    private Role role;
}
