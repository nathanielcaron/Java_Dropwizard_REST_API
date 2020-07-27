package org.nathanielcaron.resources;

import com.codahale.metrics.annotation.Timed;
import org.nathanielcaron.model.Pet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/pet")
@Produces(MediaType.APPLICATION_JSON)
public class PetResource {

    private final String defaultPetName;
    private final Integer defaultPetAge;
    private final String defaultOwnerName;

    public PetResource(String defaultPetName, Integer defaultPetAge, String defaultOwnerName){
        this.defaultPetName = defaultPetName;
        this.defaultPetAge = defaultPetAge;
        this.defaultOwnerName = defaultOwnerName;
    }

    @GET
    @Timed
    public Pet getPerson(@QueryParam("petName") String petName,
                         @QueryParam("petAge") Integer petAge,
                         @QueryParam("ownerName") String ownerName){
        if (petName != null && petAge != null && ownerName != null) {
            return new Pet(petName, petAge, ownerName);
        } else if (petName == null && petAge != null && ownerName != null) {
            return new Pet(defaultPetName, petAge, ownerName);
        } else if (petName != null && petAge == null && ownerName != null) {
            return new Pet(petName, defaultPetAge, ownerName);
        } else if (petName != null && petAge != null && ownerName == null) {
            return new Pet(petName, petAge, defaultOwnerName);
        } else if (petName == null && petAge == null && ownerName != null) {
            return new Pet(defaultPetName, defaultPetAge, ownerName);
        } else if (petName == null && petAge != null && ownerName == null) {
            return new Pet(defaultPetName, petAge, defaultOwnerName);
        } else if (petName != null && petAge == null && ownerName == null) {
            return new Pet(petName, defaultPetAge, defaultOwnerName);
        } else {
            return new Pet(defaultPetName, defaultPetAge, defaultOwnerName);
        }
    }
}