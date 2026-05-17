package main

import (
	"log"
    "net/http"

	"sms-store/consumer"
	"sms-store/db"
	"sms-store/handler"
)

func main() {c

	// Connect MongoDB
	db.ConnectMongo()

	// Start Kafka Consumer
	go consumer.StartConsumer()
    
	http.HandleFunc(
	"/v1/user/",
	handler.GetMessages,
)

http.HandleFunc(
	"/v1/store",
	handler.StoreSMS,
)
	log.Println("Go SMS Store Service Running")

	log.Fatal(http.ListenAndServe(":8082", nil))
}