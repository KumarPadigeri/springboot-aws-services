package com.practice.rest;

import com.practice.service.SQSService;
import com.test.api.AwsApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Created 1/25/24
 * @Project springboot-aws-services
 * @User Kumar Padigeri
 */
@Controller
@RestController
@RequiredArgsConstructor
@Slf4j
public class SQSController implements AwsApi {

    private final SQSService sqsService;

    @Override
    public ResponseEntity<String> sendMsgToSQS(String message) {

        try {
            sqsService.sendMsgToSQSTopic(message);
            return new ResponseEntity<>("Msg send successfully", HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Failed to sent Msg", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
