package com.lab.billing_service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BillingConsumer {

    @KafkaListener(topics = "order-topic", groupId = "billing-group")
    public void consumeOrder(String order) {
        System.out.println("=== BILLING SERVICE ===");
        System.out.println("Received order event: " + order);
        System.out.println("Generating invoice for order...");
    }
}
