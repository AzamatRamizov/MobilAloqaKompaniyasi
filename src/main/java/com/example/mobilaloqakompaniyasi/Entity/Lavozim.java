package com.example.mobilaloqakompaniyasi.Entity;

import com.example.mobilaloqakompaniyasi.AdditionalData.AbstractClass;
import com.example.mobilaloqakompaniyasi.AdditionalData.Huquqlar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Lavozim extends AbstractClass {
    @Column(nullable = false)
    private String nomi;

    @ElementCollection
    private List<Huquqlar> huquqlar;

    @Column(nullable = false)
    private String izoh;
}
