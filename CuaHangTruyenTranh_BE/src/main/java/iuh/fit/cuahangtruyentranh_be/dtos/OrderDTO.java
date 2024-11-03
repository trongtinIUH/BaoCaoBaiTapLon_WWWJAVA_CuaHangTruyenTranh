package iuh.fit.cuahangtruyentranh_be.dtos;

import iuh.fit.cuahangtruyentranh_be.enums.PaymentMethod;
import iuh.fit.cuahangtruyentranh_be.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private int customerId;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private List<OrderDetailDTO> orderDetails;
}