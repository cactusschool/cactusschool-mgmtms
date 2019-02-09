package com.ashish.cactus.school.notice.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.notice.db.model.ModuleMaster;
import com.ashish.cactus.school.notice.db.repositories.ModuleMasterRepository;
import com.ashish.cactus.school.notice.input.ModuleDetails;

@Component
@Path("/module")
public class ModuleMasterController {

	@Autowired
    private ModuleMasterRepository moduleMasterRepo;

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        // Return the DTO List:
        return "Test";
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ModuleMaster get(@PathParam("id") int id) {
    	Optional<ModuleMaster> customer = moduleMasterRepo.findById(id);

        // Return the DTO:
        return customer.get();
    }
}