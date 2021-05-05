package io.swagger.api.impl;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Character;
import io.swagger.model.CharacterList;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public class CharacterApiServiceImpl extends CharacterApiService {
    @Override
    public Response addCharacter(Character body, SecurityContext securityContext) throws NotFoundException {
        System.out.println("addCharacter");
        System.out.println(HelperFunctions.getConnectionString());
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());

            CallableStatement cStmt = conn.prepareCall("{CALL addCharacter(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cStmt.setString(1, body.getName());
            cStmt.setInt(2, body.getHeight());
            cStmt.setBigDecimal(3, body.getMass());
            cStmt.setString(4, body.getHairColor());
            cStmt.setString(5, body.getSkinColor());
            cStmt.setString(6, body.getEyeColor());
            cStmt.setString(7, body.getBirthYear());
            cStmt.setString(8, body.getGender());
            cStmt.setString(9, body.getHomeworld());
            cStmt.setString(10, body.getSpecies());

            rs = cStmt.executeQuery();
            while (rs.next()) {
                System.out.println(
                    rs.getString("name")+", "+
                    rs.getString("height")+", "+
                    rs.getString("mass")+", "+
                    rs.getString("hair_color")+", "+
                    rs.getString("skin_color")+", "+
                    rs.getString("eye_color")+", "+
                    rs.getString("birth_year")+", "+
                    rs.getString("gender")+", "+
                    rs.getString("homeworld")+", "+
                    rs.getString("species")
                );
            }
        } catch (SQLException ex) {
            return HelperFunctions.HandleError(ex);
        }
        return Response.ok().entity(body).build();
    }
    @Override
    public Response deleteCharacter(String name, SecurityContext securityContext) throws NotFoundException {
        System.out.println("deleteCharacter");
        System.out.println(HelperFunctions.getConnectionString());
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());

            CallableStatement cStmt = conn.prepareCall("{CALL deleteCharacter(?)}");
            cStmt.setString(1, name);

            int deleted = cStmt.executeUpdate();
            if(deleted >= 1){
                return Response.status(Response.Status.OK).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException ex) {
            return HelperFunctions.HandleError(ex);
        }
    }
    @Override
    public Response getCharacter(String name, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getMass(Integer mass, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateCharacter(Character body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
