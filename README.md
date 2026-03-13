# Microservices Kafka Lab

This project demonstrates a simple **Event-Driven Microservices Architecture** using **Spring Boot** and **Apache Kafka**.

## Technologies Used
- Java 17
- Spring Boot
- Spring Cloud Gateway
- Apache Kafka (KRaft Mode)
- Docker
- Maven
- Postman

## Architecture

```
Client (Postman)
      ↓
API Gateway (8080)
      ↓
Order Service (8081)
      ↓
Kafka (9092)
      ↓
Inventory Service (8082)
Billing Service (8083)
```

## How It Works

1. Client sends a request to create an order.
2. API Gateway forwards the request to the Order Service.
3. Order Service publishes an event to Kafka topic **order-topic**.
4. Inventory Service consumes the event and updates stock.
5. Billing Service consumes the event and generates an invoice.

## Running the Project

Start Kafka using Docker:

```bash
docker-compose up -d
```

Run each service:

```bash
cd order-service
mvn spring-boot:run
```

```bash
cd inventory-service
mvn spring-boot:run
```

```bash
cd billing-service
mvn spring-boot:run
```

```bash
cd api-gateway
mvn spring-boot:run
```

## Testing with Postman

Request:

```
POST http://localhost:8080/orders
```

Example JSON body:

```json
{
  "orderId": "ORD-1001",
  "item": "Laptop",
  "quantity": 1
}
```

## Result

- Order Service publishes event to Kafka
- Inventory Service receives event and updates stock
- Billing Service receives event and generates invoice
