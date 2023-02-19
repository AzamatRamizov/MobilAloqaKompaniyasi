package com.example.mobilaloqakompaniyasi.Entity;

import com.example.mobilaloqakompaniyasi.AdditionalData.AbstractClass;
import com.example.mobilaloqakompaniyasi.AdditionalData.Huquqlar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users extends AbstractClass implements UserDetails {

    @Column(nullable = false)
    private String ism;

    @Column(nullable = false)
    private String familiya;

    @Column(nullable = false)
    private String otaIsm;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public Users(String ism, String familiya, String otaIsm, String username, String password, Lavozim lavozim, boolean enabled) {
        this.ism = ism;
        this.familiya = familiya;
        this.otaIsm = otaIsm;
        this.username = username;
        this.password = password;
        this.lavozim = lavozim;
        this.enabled = enabled;
    }

    @ManyToOne
    private Lavozim lavozim;

    @OneToOne
    private Addres addres;

    @ManyToOne
    private Filial filial;

    private boolean accountNonExpired=true;
    private boolean accountNonLocked=true;
    private boolean credentialsNonExpired=true;
    private boolean enabled=false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Huquqlar> huquqlar = this.lavozim.getHuquqlar();
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        for (Huquqlar huquqlar1 : huquqlar) {
            grantedAuthorityList.add(new SimpleGrantedAuthority(huquqlar1.name()));
        }
        return grantedAuthorityList;
    }

}
