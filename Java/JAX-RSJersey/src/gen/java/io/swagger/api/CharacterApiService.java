package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Character;
import io.swagger.model.CharacterList;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public abstract class CharacterApiService {
    public abstract Response addCharacter(Character body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCharacter(String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getCharacter(String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMass(Integer mass,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCharacter(Character body,SecurityContext securityContext) throws NotFoundException;
}
