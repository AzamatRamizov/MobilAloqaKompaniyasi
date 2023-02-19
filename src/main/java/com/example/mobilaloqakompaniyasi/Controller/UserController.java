package com.example.mobilaloqakompaniyasi.Controller;

import com.example.mobilaloqakompaniyasi.AdditionalData.APIResponse;
import com.example.mobilaloqakompaniyasi.Dto.LoginDto;
import com.example.mobilaloqakompaniyasi.Dto.UsersDto;
import com.example.mobilaloqakompaniyasi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDto loginDto){
        APIResponse apiResponse=userService.login(loginDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody UsersDto usersDto){
        APIResponse apiResponse=userService.add(usersDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
    @PutMapping("/edit/{username}")
    public HttpEntity<?> edit(@PathVariable String username,@RequestBody UsersDto usersDto){
        APIResponse apiResponse=userService.edit(usersDto,username);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
}
