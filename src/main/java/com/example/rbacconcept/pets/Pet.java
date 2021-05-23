package com.example.rbacconcept.pets;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Validated
@Table(name = "pets")
public class Pet extends BaseEntity{

    @Column(name = "name")
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return this.owner;
    }

    protected void setOwner(Owner owner) {
        this.owner = owner;
    }

}
