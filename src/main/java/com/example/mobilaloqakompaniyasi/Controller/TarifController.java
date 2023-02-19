package com.example.mobilaloqakompaniyasi.Controller;

import com.example.mobilaloqakompaniyasi.AdditionalData.APIResponse;
import com.example.mobilaloqakompaniyasi.Entity.Tarif;
import com.example.mobilaloqakompaniyasi.Repository.TarifRepository;
import com.example.mobilaloqakompaniyasi.Service.TarifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarif")
public class TarifController {

    @Autowired
    TarifService tarifService;
    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody Tarif tarif){
        APIResponse apiResponse=tarifService.add(tarif);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@RequestBody Tarif tarif){
        APIResponse apiResponse=tarifService.edit(id,tarif);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> del(@PathVariable Integer id){
        APIResponse apiResponse=tarifService.delete(id);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/read/{id}")
    public HttpEntity<?> read(@PathVariable Integer id){
        APIResponse apiResponse=tarifService.read(id);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
}
