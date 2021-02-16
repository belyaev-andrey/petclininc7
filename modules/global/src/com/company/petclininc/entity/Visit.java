package com.company.petclininc.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@PublishEntityChangedEvents
@Table(name = "PETCLININC_VISIT")
@Entity(name = "petclininc_Visit")
@NamePattern("%s : %s|pet,date")
@Listeners("petclininc_VisitEntityListener")
public class Visit extends StandardEntity {
    private static final long serialVersionUID = -2600362585175201831L;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "VETERINARIAN_ID")
    private Veterinarian veterinarian;

    @NotNull
    @Column(name = "DATE_", nullable = false)
    private LocalDateTime date;

    @NotNull
    @Column(name = "DURATION", nullable = false)
    @PositiveOrZero
    private Integer duration;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    @PositiveOrZero
    private BigDecimal amount;

    @JoinTable(name = "PETCLININC_VISIT_CONSUMABLE_LINK",
            joinColumns = @JoinColumn(name = "VISIT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CONSUMABLE_ID"))
    @ManyToMany
    private List<Consumable> consumables;

    @Column(name = "NUMBER_")
    private Long number;

    @MetaProperty(related = {"date", "duration"})
    public LocalDateTime getEndDate() {
        return date.plusHours(duration);
    }

    @MetaProperty(related = {"pet", "date"})
    public String getCaption() {
        final String petName = pet != null ? pet.getName() : "";
        return String.format("%s (%s)", petName, date);
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<Consumable> getConsumables() {
        return consumables;
    }

    public void setConsumables(List<Consumable> consumables) {
        this.consumables = consumables;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @PostConstruct
    public void postConstruct() {
        duration = 1;
        amount = BigDecimal.ZERO;
        date = LocalDateTime.now();
    }

}