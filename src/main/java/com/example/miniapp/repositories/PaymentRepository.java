package com.example.miniapp.repositories;

import com.example.miniapp.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PaymentRepository  extends JpaRepository<Payment, Long> {
    // Custom query to find payments by trip ID
    List<Payment> findByTripId(Long tripId);

    // Custom query to find payments that exceed a certain amount
    @Query("SELECT p FROM Payment p WHERE p.amount > :threshold")
    List<Payment> findByAmountThreshold(Double threshold);
}
