package co.dev.kh.paymentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "transaction_details")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ORDER_ID")
    private Long orderId;
    @Column(name = "MODE")
    private String paymentMode;
    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;
    @Column(name = "PAYMENT_DATE")
    private Instant paymentDate;
    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;
    @Column(name = "AMOUNT")
    private Long amount;

    public Long getId() {
        return null;
    }
}
