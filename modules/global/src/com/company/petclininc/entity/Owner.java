package com.company.petclininc.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "PETCLININC_OWNER")
@Entity(name = "petclininc_Owner")
@NamePattern("%s|name")
public class Owner extends StandardEntity {
    private static final long serialVersionUID = -130153765732496557L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "EMAIL", nullable = false, unique = true)
    @Email
    private String email;

    @Column(name = "PHONE_NO", unique = true)
    private String phoneNo;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}