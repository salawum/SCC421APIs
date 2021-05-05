package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Planet;
import io.swagger.model.PlanetList;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public abstract class PlanetApiService {
    public abstract Response addPlanet(Planet body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deletePlanet(String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPlanet(String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getTerrain(String terrain,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUninhabited(SecurityContext securityContext) throws NotFoundException;
    public abstract Response updatePlanet(Planet body,SecurityContext securityContext) throws NotFoundException;
}
