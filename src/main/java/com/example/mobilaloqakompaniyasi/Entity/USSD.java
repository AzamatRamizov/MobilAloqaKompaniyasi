package com.example.mobilaloqakompaniyasi.Entity;

import com.example.mobilaloqakompaniyasi.AdditionalData.AbstractClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class USSD extends AbstractClass {
    private String kod;
    private String matn;
    private String izoh;
}
