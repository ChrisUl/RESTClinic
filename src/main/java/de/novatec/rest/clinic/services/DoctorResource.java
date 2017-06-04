package de.novatec.rest.clinic.services;

import de.novatec.rest.clinic.business.DoctorBf;
import de.novatec.rest.clinic.domain.doctor.Doctor;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Resource for {@link Doctor}.
 */
@Path("doctors")
public class DoctorResource {

    private DoctorBf doctorBf = new DoctorBf();

    @POST
    @Consumes("application/xml")
    public Response createDoctorPost(@Context UriInfo uriInfo, Doctor doctor) throws URISyntaxException {
        Doctor created = doctorBf.create(doctor, uriInfo.getAbsolutePath());

        URI createdUri = created.getSelf();

        return Response.created(createdUri).build();
    }
    
    @GET
    @Path("{id}")
    public Response getDoctor(@PathParam("id") String id) {
    	Doctor found = doctorBf.findById(id);
    	
    	if (found == null) {
    		throw new NotFoundException();
    	}
    	
    	return Response.ok(found).build();
    }
    

}
