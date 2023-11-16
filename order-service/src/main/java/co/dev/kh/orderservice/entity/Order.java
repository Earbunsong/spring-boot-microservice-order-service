package co.dev.kh.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@Table(name = "order-service")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "QUANTITY")
    private Long quantity;
    @Column(name = "ORDER_DATA")
    private Instant orderDate;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "TOTAL")
    private Long amount;
}
