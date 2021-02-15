package com.company.petclininc.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "PETCLININC_PET")
@Entity(name = "petclininc_Pet")
@NamePattern("%s (%s)|name,owner")
public class Pet extends StandardEntity {
    private static final long serialVersionUID = 3076508721652547297L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PET_TYPE_ID")
    private PetType petType;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}