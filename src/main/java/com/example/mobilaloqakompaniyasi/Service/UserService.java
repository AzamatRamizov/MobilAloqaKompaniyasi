package com.example.mobilaloqakompaniyasi.Service;

import com.example.mobilaloqakompaniyasi.AdditionalData.APIResponse;
import com.example.mobilaloqakompaniyasi.AdditionalData.TokenGen;
import com.example.mobilaloqakompaniyasi.Dto.LoginDto;
import com.example.mobilaloqakompaniyasi.Dto.UsersDto;
import com.example.mobilaloqakompaniyasi.Entity.Addres;
import com.example.mobilaloqakompaniyasi.Entity.Filial;
import com.example.mobilaloqakompaniyasi.Entity.Lavozim;
import com.example.mobilaloqakompaniyasi.Entity.Users;
import com.example.mobilaloqakompaniyasi.Repository.AddresRepository;
import com.example.mobilaloqakompaniyasi.Repository.FilialRepository;
import com.example.mobilaloqakompaniyasi.Repository.LavozimRepository;
import com.example.mobilaloqakompaniyasi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenGen tokenGen;

    @Autowired
    FilialRepository filialRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AddresRepository addresRepository;

    @Autowired
    LavozimRepository lavozimRepository;

    @Autowired
    AuthenticationManager authenticationManager;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> byUsername = userRepository.findByUsername(username);
        if(byUsername.isPresent()){
            return (UserDetails) byUsername.get();
        }
        return (UserDetails) new UsernameNotFoundException("Topilmadi");
    }

    public APIResponse login(LoginDto loginDto) {
        try{
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
            Users user = (Users) authenticate.getPrincipal();
            String token = tokenGen.token(user.getUsername(), user.getLavozim());
            return new APIResponse("Platformaga kirildi: "+token,true);
        }catch (BadCredentialsException badCredentialsException){
            return new APIResponse("Login yoki parol xato",false);
        }
    }

    public APIResponse add(UsersDto usersDto) {
        Optional<Lavozim> bylavozim = lavozimRepository.findByNomi(usersDto.getLavozim());
        if(!bylavozim.isPresent()){
            return new APIResponse("Lavozim mavjud mavjud emas",false);
        }
        Optional<Filial> byfilial = filialRepository.findByNom(usersDto.getFilial());
        if(!byfilial.isPresent()){
            return new APIResponse("Filial mavjud emas",false);
        }
        Filial filial = byfilial.get();
        Lavozim lavozim = bylavozim.get();
        Users users = new Users();
        users.setIsm(usersDto.getIsm());
        users.setFamiliya(usersDto.getFamiliya());
        users.setOtaIsm(usersDto.getOtaIsm());
        users.setUsername(usersDto.getUsername());
        users.setPassword(passwordEncoder.encode(usersDto.getPassword()));
        users.setLavozim(lavozim);
        Addres addres=new Addres();
        addres.setViloyat(usersDto.getViloyat());
        addres.setTuman(usersDto.getTuman());
        addres.setKucha(usersDto.getKucha());
        addres.setUy(usersDto.getUy());
        Addres save = addresRepository.save(addres);
        users.setAddres(addres);
        users.setFilial(filial);
        userRepository.save(users);
        return new APIResponse("User added succesfully",true);
    }

    public APIResponse edit(UsersDto usersDto, String username) {
        Optional<Users> byUsername = userRepository.findByUsername(username);
        if(!byUsername.isPresent()){
            return new APIResponse("Username topilmadi",false);
        }
        Optional<Filial> byNom = filialRepository.findByNom(usersDto.getFilial());
        if(!byNom.isPresent()){
            return new APIResponse("Filial mavjud emas",false);
        }
        Filial filial = byNom.get();
        Users users = byUsername.get();
        users.setIsm(usersDto.getIsm());
        users.setFamiliya(usersDto.getFamiliya());
        users.setOtaIsm(usersDto.getOtaIsm());
        users.setUsername(usersDto.getUsername());
        users.setPassword(usersDto.getPassword());
//        Optional<Addres> byViloyatAndTumanAndKuchaAndUy = addresRepository.findByViloyatAndTumanAndKuchaAndUy(usersDto.getViloyat(), usersDto.getTuman(), usersDto.getKucha(), usersDto.getUy());
        Addres addres = users.getAddres();
        addres.setViloyat(usersDto.getViloyat());
        addres.setTuman(usersDto.getTuman());
        addres.setKucha(usersDto.getKucha());
        addres.setUy(usersDto.getUy());
        addresRepository.save(addres);
        users.setFilial(filial);
        userRepository.save(users);
        return new APIResponse("User updated succesfully",true);
    }
}
