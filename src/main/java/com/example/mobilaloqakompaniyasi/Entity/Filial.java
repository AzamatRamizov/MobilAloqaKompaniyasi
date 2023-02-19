package com.example.mobilaloqakompaniyasi.Entity;

import com.example.mobilaloqakompaniyasi.AdditionalData.AbstractClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Filial extends AbstractClass {

    @Column(nullable = false)
    private String nom;

    @OneToOne
    private Addres addres;
}
