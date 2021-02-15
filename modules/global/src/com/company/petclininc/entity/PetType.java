package com.company.petclininc.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "PETCLININC_PET_TYPE")
@Entity(name = "petclininc_PetType")
@NamePattern("%s|name")
public class PetType extends StandardEntity {
    private static final long serialVersionUID = -8801889534628011552L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}