package com.ashish.cactus.school.notice.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.notice.controller.ModuleMasterController;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        // Register the Filters:
        register(TenantNameFilter.class);

        // Register the Resources:
        register(ModuleMasterController.class);

        // Uncomment to disable WADL Generation:
        //property("jersey.config.server.wadl.disableWadl", true);

        // Uncomment to add Request Tracing:
        //property("jersey.config.server.tracing.type", "ALL");
        //property("jersey.config.server.tracing.threshold", "TRACE");
    }
}