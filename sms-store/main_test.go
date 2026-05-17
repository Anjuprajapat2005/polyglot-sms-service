package main

import "testing"

func TestSample(t *testing.T) {

	phone := "9999999999"

	if phone != "9999999999" {
		t.Error("Phone number mismatch")
	}
}