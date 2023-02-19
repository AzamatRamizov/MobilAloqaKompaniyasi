package com.example.mobilaloqakompaniyasi.Controller;

import com.example.mobilaloqakompaniyasi.AdditionalData.APIResponse;
import com.example.mobilaloqakompaniyasi.Dto.UssdCodes;
import com.example.mobilaloqakompaniyasi.Entity.USSD;
import com.example.mobilaloqakompaniyasi.Service.UssdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ussd")
public class USSDController {
    @Autowired
    UssdService ussdService;
    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody USSD ussd){
        return ResponseEntity.status(200).body("s");
    }
    @PostMapping("/read")
    public HttpEntity<?> read(@RequestBody UssdCodes ussdCodes){
        APIResponse apiResponse=ussdService.read(ussdCodes);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
}
