package lk.isuri.devhub.paymentservice.repository;

import lk.isuri.devhub.paymentservice.model.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {

    Optional<TransactionDetails> findByOrderId(long orderId);
}