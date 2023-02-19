package com.example.mobilaloqakompaniyasi.Entity;

import com.example.mobilaloqakompaniyasi.AdditionalData.AbstractClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SimCard extends AbstractClass {

    @Column(nullable = false)
    private long balans;

    @Column(nullable = false)
    private long raqam;

    @ManyToOne
    private Tarif tarif;

    @ManyToOne
    private Users users;
}
