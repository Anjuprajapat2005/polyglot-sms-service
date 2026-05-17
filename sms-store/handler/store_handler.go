package handler

import (
	"context"
	"encoding/json"
	"net/http"

	"sms-store/db"
	"sms-store/model"
)

func StoreSMS(w http.ResponseWriter, r *http.Request) {

	var sms model.SMS

	err := json.NewDecoder(r.Body).Decode(&sms)

	if err != nil {
		http.Error(w, err.Error(), 400)
		return
	}

	_, err = db.Collection.InsertOne(
		context.TODO(),
		sms,
	)

	if err != nil {
		http.Error(w, err.Error(), 500)
		return
	}

	w.Write([]byte("Stored"))
}