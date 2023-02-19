package com.example.mobilaloqakompaniyasi.Controller;

import com.example.mobilaloqakompaniyasi.AdditionalData.APIResponse;
import com.example.mobilaloqakompaniyasi.Dto.FilialDto;
import com.example.mobilaloqakompaniyasi.Service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filial")
public class FilialController {
    @Autowired
    FilialService filialService;

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody FilialDto filialDto){
        APIResponse apiResponse=filialService.add(filialDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@RequestBody FilialDto filialDto){
        APIResponse apiResponse=filialService.edit(id,filialDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/read/{id}")
    public HttpEntity<?> read(@PathVariable Integer id){
        APIResponse apiResponse=filialService.read(id);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }

}
