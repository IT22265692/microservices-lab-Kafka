package com.lab.inventory_service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumer {

    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void consumeOrder(String order) {
        System.out.println("=== INVENTORY SERVICE ===");
        System.out.println("Received order event: " + order);
        System.out.println("Updating stock for order...");
    }
}