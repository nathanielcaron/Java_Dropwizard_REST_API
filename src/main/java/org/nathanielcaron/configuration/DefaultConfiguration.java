package org.nathanielcaron.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Default Configuration for Application
 * Author: Nathaniel Caron
 */
public class DefaultConfiguration extends Configuration {

    @NotNull
    private String petName;

    @NotNull
    private Integer petAge;

    @NotNull
    private String ownerName;

    @JsonProperty
    public String getPetName() {
        return petName;
    }

    @JsonProperty
    public void setPetName(String petName) {
        this.petName = petName;
    }

    @JsonProperty
    public Integer getPetAge() {
        return petAge;
    }

    @JsonProperty
    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    @JsonProperty
    public String getOwnerName() {
        return ownerName;
    }

    @JsonProperty
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}