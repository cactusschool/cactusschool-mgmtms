package com.ashish.cactus.school.notice.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.notice.admin.db.repositories.SchoolMasterRepository;
import com.ashish.cactus.school.notice.db.model.ModuleMaster;
import com.ashish.cactus.school.notice.db.repositories.ModuleMasterRepository;
import com.ashish.cactus.school.notice.input.ModuleDetails;

@Component
@Path("/module")
public class ModuleMasterController {

	@Autowired
    private ModuleMasterRepository moduleMasterRepo;

	@Autowired
	private SchoolMasterRepository schoolMasterRepo;
	
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        // Return the DTO List:
    	String contextRoot = null;
    	try {
    		contextRoot = schoolMasterRepo.findById(1).get().getContextRoot();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return contextRoot;
//        return "Test";
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN_CREATE','ROLE_ADMIN_UPDATE','ROLE_PRINCIPAL_CREATE')")
    public ModuleMaster get(@PathParam("id") int id) {
    	Optional<ModuleMaster> customer = moduleMasterRepo.findById(id);

        // Return the DTO:
        return customer.get();
    }
}