package handler

import (
	"context"
	"encoding/json"
	"net/http"
	"strings"

	"sms-store/db"
)

func GetMessages(w http.ResponseWriter, r *http.Request) {

	parts := strings.Split(r.URL.Path, "/")

	phone := parts[len(parts)-2]

	cursor, err := db.Collection.Find(
		context.TODO(),
		map[string]string{
			"phoneNumber": phone,
		},
	)

	if err != nil {
		http.Error(w, err.Error(), 500)
		return
	}

	var results []map[string]interface{}

	cursor.All(context.TODO(), &results)

	w.Header().Set("Content-Type", "application/json")

	json.NewEncoder(w).Encode(results)
}