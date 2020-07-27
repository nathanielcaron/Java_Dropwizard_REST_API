package org.nathanielcaron.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pet {

    private String petName;
    private Integer petAge;
    private String ownerName;

    public Pet() {}

    public Pet(String petName, Integer petAge, String ownerName) {
        this.petName = petName;
        this.petAge = petAge;
        this.ownerName = ownerName;
    }

    @JsonProperty
    public String getPetName() {
        return petName;
    }

    @JsonProperty
    public Integer getPetAge() {
        return petAge;
    }

    @JsonProperty
    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return "Pet {" +
                "petName= '" + petName + "'" +
                ", petAge= '" + petAge + "'" +
                ", ownerName= '" + ownerName + "'" +
                " }";
    }
}
