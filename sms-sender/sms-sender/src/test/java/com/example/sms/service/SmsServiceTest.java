package com.example.sms.service;

import com.example.sms.model.SmsRequest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmsServiceTest {

    @Test
    void testSmsRequestCreation() {

        SmsRequest request = new SmsRequest();

        request.setPhoneNumber("9999999999");
        request.setMessage("Hello");

        assertEquals(
                "9999999999",
                request.getPhoneNumber()
        );

        assertEquals(
                "Hello",
                request.getMessage()
        );
    }
}