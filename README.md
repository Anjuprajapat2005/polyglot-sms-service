\# Polyglot SMS Microservices System



A distributed microservices-based SMS processing system built using Java Spring Boot, GoLang, Kafka, Redis, MongoDB, and Docker Compose.



\---



\# 🚀 Architecture



Client Request

↓

Spring Boot SMS Service

↓

Redis Block Validation

↓

Kafka Producer

↓

GoLang Kafka Consumer

↓

MongoDB Storage



\---



\# 🛠 Tech Stack



\## Backend

\- Java Spring Boot

\- GoLang



\## Messaging

\- Apache Kafka



\## Database

\- MongoDB



\## Cache / Validation

\- Redis



\## Containerization

\- Docker

\- Docker Compose



\## API Testing

\- Postman



\---



\# 📂 Project Structure



sms-project

│

├── sms-sender      # Spring Boot Producer Service

│

├── sms-store       # GoLang Consumer Service

│

└── docker-compose.yml



\---



\# 🚀 Features



✅ SMS Sending API  

✅ Kafka Event Streaming  

✅ Redis Blocked User Validation  

✅ MongoDB SMS Storage  

✅ GoLang Kafka Consumer  

✅ REST APIs  

✅ Dockerized Infrastructure  

✅ Unit Testing  

✅ Swagger API Documentation  



\---



\# 🚀 APIs



\## Send SMS



POST /v1/sms/send



\### Request



```json

{

&#x20; "phoneNumber":"9999999999",

&#x20; "message":"Hello World"

}



\# 🚀 End-to-End Flow Demonstration



\## 1️⃣ Start Docker Infrastructure



```bash

docker-compose up

