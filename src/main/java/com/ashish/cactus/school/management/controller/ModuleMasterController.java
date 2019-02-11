package com.ashish.cactus.school.management.controller;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.management.admin.db.repositories.AdminSchoolMasterRepository;
import com.ashish.cactus.school.management.db.model.AcademicYear;
import com.ashish.cactus.school.management.db.repositories.AcademicYearMasterRepository;

@Component
@Path("/module")
public class ModuleMasterController {

	@Autowired
    private AcademicYearMasterRepository academicMasterRepo;

	@Autowired
	private AdminSchoolMasterRepository adminSchoolMasterRepo;
	
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        // Return the DTO List:
    	String contextRoot = null;
    	try {
    		contextRoot = adminSchoolMasterRepo.findById(1).get().getContextRoot();
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
    public AcademicYear get(@PathParam("id") int id) {
    	Optional<AcademicYear> customer = academicMasterRepo.findById(id);

        // Return the DTO:
        return customer.get();
    }
}