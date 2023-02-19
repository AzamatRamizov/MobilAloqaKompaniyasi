package com.example.mobilaloqakompaniyasi.Service;

import com.example.mobilaloqakompaniyasi.AdditionalData.APIResponse;
import com.example.mobilaloqakompaniyasi.Dto.UssdCodes;
import com.example.mobilaloqakompaniyasi.Entity.SimCard;
import com.example.mobilaloqakompaniyasi.Entity.Users;
import com.example.mobilaloqakompaniyasi.Repository.SimCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UssdService {
    @Autowired
    SimCardRepository simCardRepository;
    public APIResponse read(UssdCodes ussdCodes) {
        if(ussdCodes.getCode()=="*102#"){
            try{
                Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
                Users users= (Users) authentication.getPrincipal();
                Optional<SimCard> byUsers = simCardRepository.findByUsers(users);
                SimCard simCard = byUsers.get();
                return new APIResponse("Balans: "+simCard.getBalans()+" so'm",true);
            }catch (BadCredentialsException badCredentialsException){
                return new APIResponse("Login yoki parol xato",false);
            }
        } else if (ussdCodes.getCode()=="*105#") {
            try{
                Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
                Users users= (Users) authentication.getPrincipal();
                Optional<SimCard> byUsers = simCardRepository.findByUsers(users);
                SimCard simCard = byUsers.get();
                return new APIResponse("Ta'rif: "+simCard.getTarif(),true);
            }catch (BadCredentialsException badCredentialsException){
                return new APIResponse("Login yoki parol xato",false);
            }
        } else if (ussdCodes.getCode()=="*148#") {
            try{
                Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
                Users users= (Users) authentication.getPrincipal();
                Optional<SimCard> byUsers = simCardRepository.findByUsers(users);
                SimCard simCard = byUsers.get();
                return new APIResponse("Raqam: "+simCard.getRaqam(),true);
            }catch (BadCredentialsException badCredentialsException){
                return new APIResponse("Login yoki parol xato",false);
            }
        }
        return new APIResponse("",true);
    }
}
