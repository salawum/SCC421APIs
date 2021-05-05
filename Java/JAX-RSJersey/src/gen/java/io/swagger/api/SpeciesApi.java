package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.SpeciesApiService;
import io.swagger.api.factories.SpeciesApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.Species;
import io.swagger.model.SpeciesList;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;


@Path("/species")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public class SpeciesApi  {
   private final SpeciesApiService delegate;

   public SpeciesApi(@Context ServletConfig servletContext) {
      SpeciesApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("SpeciesApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (SpeciesApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = SpeciesApiServiceFactory.getSpeciesApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json", "application/xml" })
    
    @Operation(summary = "Add a species to the database", description = "", tags={ "Species" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully added Species to database"),
        
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        
        @ApiResponse(responseCode = "404", description = "Species not found"),
        
        @ApiResponse(responseCode = "409", description = "Conflict with existing data") })
    public Response addSpecies(@Parameter(in = ParameterIn.DEFAULT, description = "Species object to be added to the database" ,required=true) Species body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addSpecies(body,securityContext);
    }
    @DELETE
    @Path("/{name}")
    
    
    @Operation(summary = "Delete a species from the database", description = "", tags={ "Species" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully deleted Species object from the database"),
        
        @ApiResponse(responseCode = "400", description = "Invalid name supplied"),
        
        @ApiResponse(responseCode = "404", description = "Species not found") })
    public Response deleteSpecies(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("name") String name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteSpecies(name,securityContext);
    }
    @GET
    @Path("/eye/{eye_color}")
    
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Get a list of species with the specified eye color", description = "", tags={ "Species" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully found species(s)", content = @Content(schema = @Schema(implementation = SpeciesList.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid eye color supplied"),
        
        @ApiResponse(responseCode = "404", description = "Species(s) not found") })
    public Response getEyeColor(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("eye_color") String eyeColor
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getEyeColor(eyeColor,securityContext);
    }
    @GET
    @Path("/{name}")
    
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Get a species from the database", description = "", tags={ "Species" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully found Species object", content = @Content(schema = @Schema(implementation = Species.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid name supplied"),
        
        @ApiResponse(responseCode = "404", description = "Species not found") })
    public Response getSpecies(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("name") String name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getSpecies(name,securityContext);
    }
    @PUT
    
    @Consumes({ "application/json", "application/xml" })
    
    @Operation(summary = "Update an existing species", description = "", tags={ "Species" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully updated Species object"),
        
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        
        @ApiResponse(responseCode = "404", description = "Species not found"),
        
        @ApiResponse(responseCode = "409", description = "Conflict with existing data") })
    public Response updateSpecies(@Parameter(in = ParameterIn.DEFAULT, description = "Species object to be updated" ,required=true) Species body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateSpecies(body,securityContext);
    }
}
