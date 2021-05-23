package com.example.rbacconcept.pets;

import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Validated
@Table(name = "owners")
public class Owner extends BaseEntity{

    @Column(name = "owner_name")
    @NotEmpty
    private String name;

    @Column(name = "phone")
    @Pattern(regexp = "(\\+?6?01)[0-46-9]-*[0-9]{7,8}")
    private String phone;

    @OneToMany(targetEntity = Pet.class, cascade = CascadeType.ALL,
             fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pet> pet;


    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public List<Pet> getPet() {
        return pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
    }

}
