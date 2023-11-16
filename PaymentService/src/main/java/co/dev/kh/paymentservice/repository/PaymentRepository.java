package co.dev.kh.paymentservice.repository;

import co.dev.kh.paymentservice.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<TransactionDetails,Long> {

}
