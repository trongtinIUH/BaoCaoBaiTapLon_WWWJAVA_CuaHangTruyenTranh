package iuh.fit.cuahangtruyentranh_be.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import iuh.fit.cuahangtruyentranh_be.enums.PaymentMethod;
import iuh.fit.cuahangtruyentranh_be.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, unique = true)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderDetail> orderDetails;

    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus;

    public Order(Customer customer, LocalDateTime orderDate, PaymentMethod paymentMethod, PaymentStatus paymentStatus) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

}
