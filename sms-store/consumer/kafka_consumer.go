package consumer
import (
	"context"
	"encoding/json"
	"log"

	"github.com/segmentio/kafka-go"

	"sms-store/db"
	"sms-store/model"
)


func StartConsumer() {

	r := kafka.NewReader(kafka.ReaderConfig{
		Brokers: []string{"localhost:9092"},
		Topic:   "sms-topic",
		GroupID: "sms-group",
	})

	for {

		msg, err := r.ReadMessage(context.Background())

		if err != nil {
			log.Println(err)
			continue
		}

		log.Println("Received:", string(msg.Value))

		// parts := strings.Split(string(msg.Value), "|")
        var sms model.SMS

err = json.Unmarshal(msg.Value, &sms)

if err != nil {
    log.Println(err)
    continue
} 
		// if len(parts) != 3 {
		// 	log.Println("Invalid message")
		// 	continue
		// }

		// sms := model.SMS{
		// 	PhoneNumber: parts[0],
		// 	Message:     parts[1],
		// 	Status:      parts[2],
		// }

		_, err = db.Collection.InsertOne(
			context.TODO(),
			sms,
		)

		if err != nil {
			log.Println(err)
		} else {
			log.Println("Saved to MongoDB")
		}
	}
}