package br.com.coradini.flowable.example.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service("paymentService")
@Log4j2
public class PaymentService {

    public Map<String, AtomicInteger> paymentConfirmations = new ConcurrentHashMap<>();

    public void verifyPayment(String orderId, String email){
        log.info("Verifiy payment for: " + orderId + " and email: "+ email);
        paymentConfirmations.computeIfAbsent(email, e -> new AtomicInteger());
        paymentConfirmations.get(email).incrementAndGet();

    }
}
