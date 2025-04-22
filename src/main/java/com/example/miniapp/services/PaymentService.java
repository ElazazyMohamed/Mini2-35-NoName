package com.example.miniapp.services;

import com.example.miniapp.models.Payment;
import com.example.miniapp.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Service methods for Payment entity

    // Add a new payment
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payments by trip ID
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    //update payment
    public Payment updatePayment(Long id, Payment payment) {
        if (paymentRepository.existsById(id)) {
            payment.setId(id);
            return paymentRepository.save(payment);
        }
        return null;
    }

    //delete payment
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    // Get payments by trip ID
    public List<Payment> getPaymentsByTripId(Long tripId) {
        return paymentRepository.findByTripId(tripId);
    }

    // Get payments with amount greater than a threshold
    public List<Payment> findByAmountThreshold(Double threshold) {
        return paymentRepository.findByAmountThreshold(threshold);
    }
}
