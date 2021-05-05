package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.PlanetApiService;
import io.swagger.api.factories.PlanetApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.Planet;
import io.swagger.model.PlanetList;

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


@Path("/planet")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public class PlanetApi  {
   private final PlanetApiService delegate;

   public PlanetApi(@Context ServletConfig servletContext) {
      PlanetApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("PlanetApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (PlanetApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = PlanetApiServiceFactory.getPlanetApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json", "application/xml" })
    
    @Operation(summary = "Add a planet to the database", description = "", tags={ "Planets" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully added Planet object to the database"),
        
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        
        @ApiResponse(responseCode = "404", description = "Planet not found"),
        
        @ApiResponse(responseCode = "409", description = "Conflict with existing data") })
    public Response addPlanet(@Parameter(in = ParameterIn.DEFAULT, description = "Planet object to be added to the database" ,required=true) Planet body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addPlanet(body,securityContext);
    }
    @DELETE
    @Path("/{name}")
    
    
    @Operation(summary = "Delete a planet from the database", description = "", tags={ "Planets" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully deleted Planet object from the database"),
        
        @ApiResponse(responseCode = "400", description = "Invalid name supplied"),
        
        @ApiResponse(responseCode = "404", description = "Planet not found") })
    public Response deletePlanet(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("name") String name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deletePlanet(name,securityContext);
    }
    @GET
    @Path("/{name}")
    
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Get a planet from the database", description = "", tags={ "Planets" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully found Planet object", content = @Content(schema = @Schema(implementation = Planet.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid name supplied"),
        
        @ApiResponse(responseCode = "404", description = "Planet not found") })
    public Response getPlanet(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("name") String name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPlanet(name,securityContext);
    }
    @GET
    @Path("/terrain/{terrain}")
    
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Get a list of planets with the specified terrain type", description = "", tags={ "Planets" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully found planet(s)", content = @Content(schema = @Schema(implementation = PlanetList.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid terrain supplied"),
        
        @ApiResponse(responseCode = "404", description = "Planet(s) not found") })
    public Response getTerrain(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("terrain") String terrain
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getTerrain(terrain,securityContext);
    }
    @GET
    @Path("/uninhabited")
    
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Get a list of planets that are uninhabited", description = "", tags={ "Planets" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully found planet(s)", content = @Content(schema = @Schema(implementation = PlanetList.class))),
        
        @ApiResponse(responseCode = "404", description = "Planet(s) not found") })
    public Response getUninhabited(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getUninhabited(securityContext);
    }
    @PUT
    
    @Consumes({ "application/json", "application/xml" })
    
    @Operation(summary = "Update an existing planet", description = "", tags={ "Planets" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully updated Planet object"),
        
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        
        @ApiResponse(responseCode = "404", description = "Planet not found"),
        
        @ApiResponse(responseCode = "409", description = "Conflict with existing data") })
    public Response updatePlanet(@Parameter(in = ParameterIn.DEFAULT, description = "Planet object to be updated" ,required=true) Planet body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updatePlanet(body,securityContext);
    }
}
