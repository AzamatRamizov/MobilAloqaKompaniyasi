package com.example.mobilaloqakompaniyasi.Controller;

import com.example.mobilaloqakompaniyasi.AdditionalData.APIResponse;
import com.example.mobilaloqakompaniyasi.Dto.SimDto;
import com.example.mobilaloqakompaniyasi.Service.SimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sim")
public class SimCardController {
    @Autowired
    SimService simService;
    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody SimDto simDto){
        APIResponse apiResponse=simService.add(simDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
}
