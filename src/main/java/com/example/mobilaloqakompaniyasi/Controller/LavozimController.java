package com.example.mobilaloqakompaniyasi.Controller;

import com.example.mobilaloqakompaniyasi.AdditionalData.APIResponse;
import com.example.mobilaloqakompaniyasi.Entity.Lavozim;
import com.example.mobilaloqakompaniyasi.Service.LavozimService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lavozim")
public class LavozimController {

    @Autowired
    LavozimService lavozimService;

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody Lavozim lavozim){
        APIResponse apiResponse=lavozimService.add(lavozim);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }

    @PutMapping("/edit/{nomi}")
    public HttpEntity<?> edit(@RequestBody Lavozim lavozim,@PathVariable String nomi){
        APIResponse apiResponse=lavozimService.edit(lavozim,nomi);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
    @DeleteMapping("/delete/{nomi}")
    public HttpEntity<?> del(@PathVariable String nomi){
        APIResponse apiResponse=lavozimService.del(nomi);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/read/{nomi}")
    public HttpEntity<?> read(@PathVariable String nomi){
        APIResponse apiResponse=lavozimService.read(nomi);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
}
