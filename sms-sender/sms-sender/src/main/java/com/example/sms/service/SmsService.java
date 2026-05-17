package com.example.sms.service;

import com.example.sms.dto.SmsEvent;
import com.example.sms.model.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsService {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BlockService blockService;

    @Value("${kafka.topic.name}")
    private String topic;

    public String sendSms(SmsRequest request) {

        // Check blocked user
        if (blockService.isBlocked(request.getPhoneNumber())) {
            System.out.println("Number is blocked so we can not process kafka and other event");
            return "User is blocked";
        }

        // Validation
        if (request.getPhoneNumber() == null ||
                request.getMessage() == null) {

            return "FAIL";
        }

        // Mock SMS sending
        System.out.println(
                "Sending SMS to: " +
                        request.getPhoneNumber()
        );

        String status = "SUCCESS";

        // Kafka Event
//        String event =
//                request.getPhoneNumber()
//                        + "|"
//                        + request.getMessage()
//                        + "|"
//                        + status;

        String event = """
{
    "phoneNumber":"%s",
    "message":"%s",
    "status":"%s"
}
""".formatted(
                request.getPhoneNumber(),
                request.getMessage(),
                status
        );

        SmsEvent smsEvent = new SmsEvent(
                request.getPhoneNumber(),
                request.getMessage(),
                status
        );

        restTemplate.postForObject(
                "http://localhost:8082/v1/store",
                smsEvent,
                String.class
        );

        kafkaProducerService.sendMessage(topic, event);
        return status;
    }
}