package com.ashish.cactus.school.management.config;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class TenantNameFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext ctx) throws IOException {

        MultivaluedMap<String, String> headers = ctx.getHeaders();

        if(headers == null) {
            return;
        }

        if(!headers.containsKey("X-DatabaseName")) {
            return;
        }

        String tenantName = headers.getFirst("X-DatabaseName");

        if(tenantName == null) {
            return;
        }

        // Set in the Thread Context of the Request:
        ThreadLocalStorage.setTenantName(tenantName);
    }
}