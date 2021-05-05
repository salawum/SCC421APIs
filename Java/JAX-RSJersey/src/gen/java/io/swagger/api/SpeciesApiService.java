package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Species;
import io.swagger.model.SpeciesList;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public abstract class SpeciesApiService {
    public abstract Response addSpecies(Species body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteSpecies(String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getEyeColor(String eyeColor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getSpecies(String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateSpecies(Species body,SecurityContext securityContext) throws NotFoundException;
}
