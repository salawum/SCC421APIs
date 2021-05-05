package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.CharacterApiService;
import io.swagger.api.factories.CharacterApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.Character;
import io.swagger.model.CharacterList;

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


@Path("/character")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public class CharacterApi  {
   private final CharacterApiService delegate;

   public CharacterApi(@Context ServletConfig servletContext) {
      CharacterApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("CharacterApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (CharacterApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = CharacterApiServiceFactory.getCharacterApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json", "application/xml" })
    
    @Operation(summary = "Add a character to the database", description = "", tags={ "Characters" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully added character"),
        
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        
        @ApiResponse(responseCode = "404", description = "Character not found"),
        
        @ApiResponse(responseCode = "409", description = "Conflict with existing data") })
    public Response addCharacter(@Parameter(in = ParameterIn.DEFAULT, description = "Character object to be added to the database" ,required=true) Character body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addCharacter(body,securityContext);
    }
    @DELETE
    @Path("/{name}")
    
    
    @Operation(summary = "Delete a character from the database", description = "", tags={ "Characters" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully deleted Character object from the database"),
        
        @ApiResponse(responseCode = "400", description = "Invalid name supplied"),
        
        @ApiResponse(responseCode = "404", description = "Character not found") })
    public Response deleteCharacter(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("name") String name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteCharacter(name,securityContext);
    }
    @GET
    @Path("/{name}")
    
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Get a character from the database", description = "", tags={ "Characters" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully found Character object", content = @Content(schema = @Schema(implementation = Character.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid name supplied"),
        
        @ApiResponse(responseCode = "404", description = "Character not found") })
    public Response getCharacter(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("name") String name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getCharacter(name,securityContext);
    }
    @GET
    @Path("/mass/{mass}")
    
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Get a list of all charcaters with mass greater than or equal to the specified mass value", description = "", tags={ "Characters" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully found character(s) with suitable mass", content = @Content(schema = @Schema(implementation = CharacterList.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid mass supplied"),
        
        @ApiResponse(responseCode = "404", description = "Character(s) not found") })
    public Response getMass(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("mass") Integer mass
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMass(mass,securityContext);
    }
    @PUT
    
    @Consumes({ "application/json", "application/xml" })
    
    @Operation(summary = "Update an existing Character object", description = "", tags={ "Characters" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully updated character"),
        
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        
        @ApiResponse(responseCode = "404", description = "Character not found"),
        
        @ApiResponse(responseCode = "409", description = "Conflict with existing data") })
    public Response updateCharacter(@Parameter(in = ParameterIn.DEFAULT, description = "Character object to be updated" ,required=true) Character body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateCharacter(body,securityContext);
    }
}
