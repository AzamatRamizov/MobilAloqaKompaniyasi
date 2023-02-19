package com.example.mobilaloqakompaniyasi.Entity;

import com.example.mobilaloqakompaniyasi.AdditionalData.AbstractClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Addres extends AbstractClass {
    private String viloyat;
    private String tuman;
    private String kucha;
    private String uy;
}
