package com.example.mobilaloqakompaniyasi.Entity;

import com.example.mobilaloqakompaniyasi.AdditionalData.AbstractClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Tarif extends AbstractClass {
    @Column(nullable = false)
    private String nomi;
    @Column(nullable = false)
    private long narxi;
    @Column(nullable = false)
    private String muddat;
}
