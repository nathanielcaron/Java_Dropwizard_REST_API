package org.nathanielcaron;

import org.nathanielcaron.configuration.DefaultConfiguration;
import org.nathanielcaron.resources.PetResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

/**
 * Application Class
 */
public class App extends Application<DefaultConfiguration> {
    public static void main( String[] args ) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(DefaultConfiguration defaultConfiguration, Environment environment) throws Exception {
        // Initialize resources
        final PetResource petResource = new PetResource(defaultConfiguration.getPetName(),
                                                        defaultConfiguration.getPetAge(),
                                                        defaultConfiguration.getOwnerName());
        // Register resources
        environment.jersey().register(petResource);

        // Register health checks
        environment.healthChecks().register("default", new DefaultHealthCheck());
    }
}

