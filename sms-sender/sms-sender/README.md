# Polyglot Distributed SMS Service

## Overview

This project is a distributed microservice-based SMS system built using:

- Java Spring Boot
- Apache Kafka
- GoLang
- MongoDB
- Redis

The system demonstrates:
- asynchronous communication using Kafka
- synchronous communication using RestTemplate
- Redis block list validation
- MongoDB persistence

---

# Architecture

Client
↓
Java SMS Service
↓
Redis Validation
↓
Kafka Producer
↓
Go Consumer
↓
MongoDB

Also:

Java Service
↓
RestTemplate
↓
GoLang HTTP API

---

# Technologies Used

## Java Service
- Spring Boot
- Kafka Producer
- Redis
- RestTemplate

## Go Service
- GoLang
- net/http
- Kafka Consumer
- MongoDB

---

# APIs

## 1. Send SMS

### Endpoint

POST /v1/sms/send

### Request Body

```json
{
  "phoneNumber":"9999999999",
  "message":"Hello"
}