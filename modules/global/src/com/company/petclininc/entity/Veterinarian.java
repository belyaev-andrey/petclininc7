package com.company.petclininc.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Table(name = "PETCLININC_VETERINARIAN")
@Entity(name = "petclininc_Veterinarian")
@NamePattern("%s (%s)|user,hourlyRate")
public class Veterinarian extends StandardEntity {
    private static final long serialVersionUID = 3636173032161666756L;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "HOURLY_RATE")
    @PositiveOrZero
    private BigDecimal hourlyRate;

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}