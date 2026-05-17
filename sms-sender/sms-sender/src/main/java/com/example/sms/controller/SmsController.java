//package com.example.sms.controller;
//
//import com.example.sms.model.SmsRequest;
//import com.example.sms.model.SmsResponse;
//import com.example.sms.service.SmsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/v1/sms")
//public class SmsController {
//
//    @Autowired
//    private SmsService smsService;
//
//    @PostMapping("/send")
//    public SmsResponse sendSms(@RequestBody SmsRequest request) {
//
//        String status = smsService.sendSms(request);
//
//        return new SmsResponse(status, "SMS processed");
//    }
//}

package com.example.sms.controller;

import com.example.sms.model.SmsRequest;
import com.example.sms.model.SmsResponse;
import com.example.sms.service.SmsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
@RestController
@RequestMapping("/v1/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;
    @Operation(summary = "Send SMS API")

    @PostMapping("/send")
    public ResponseEntity<SmsResponse> sendSms(
            @RequestBody SmsRequest request) {

        try {

            String status =
                    smsService.sendSms(request);

            // Blocked user
            if(status.equals("User is blocked")) {

                return ResponseEntity
                        .badRequest()
                        .body(
                                new SmsResponse(
                                        "FAILED",
                                        status
                                )
                        );
            }

            // Success
            return ResponseEntity.ok(
                    new SmsResponse(
                            "SUCCESS",
                            "SMS processed"
                    )
            );

        } catch (Exception e) {

            return ResponseEntity
                    .internalServerError()
                    .body(
                            new SmsResponse(
                                    "ERROR",
                                    e.getMessage()
                            )
                    );
        }
    }
}