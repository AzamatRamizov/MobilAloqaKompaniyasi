package com.example.mobilaloqakompaniyasi.Service;

import com.example.mobilaloqakompaniyasi.AdditionalData.APIResponse;
import com.example.mobilaloqakompaniyasi.Dto.FilialDto;
import com.example.mobilaloqakompaniyasi.Entity.Addres;
import com.example.mobilaloqakompaniyasi.Entity.Filial;
import com.example.mobilaloqakompaniyasi.Repository.AddresRepository;
import com.example.mobilaloqakompaniyasi.Repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilialService {
    @Autowired
    FilialRepository filialRepository;
    @Autowired
    AddresRepository addresRepository;
    public APIResponse add(FilialDto filialDto) {
        Filial filial = new Filial();
        filial.setNom(filialDto.getNomi());
        Addres addres=new Addres();
        addres.setViloyat(filialDto.getViloyat());
        addres.setTuman(filialDto.getTuman());
        addres.setKucha(filialDto.getKucha());
        addres.setUy(filialDto.getUy());
        Addres save = addresRepository.save(addres);
        filial.setAddres(save);
        filialRepository.save(filial);
        return new APIResponse("Added",true);
    }

    public APIResponse edit(Integer id, FilialDto filialDto) {

        return new APIResponse("0",false);
    }

    public APIResponse read(Integer id) {
        Optional<Filial> byId = filialRepository.findById(id);
        if(byId.isPresent()){
            Filial filial = byId.get();
            return new APIResponse(filial.toString(),true);
        }
        return new APIResponse("Not found",false);
    }
}
