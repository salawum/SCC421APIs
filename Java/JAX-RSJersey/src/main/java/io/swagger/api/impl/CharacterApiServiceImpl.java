package io.swagger.api.impl;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Character;
import io.swagger.model.CharacterList;

import java.util.ArrayList;
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
        } catch (SQLException ex) {
            return HelperFunctions.HandleError(ex);
        }
        return Response.ok().entity(body).build();
    }
    @Override
    public Response deleteCharacter(String name, SecurityContext securityContext) throws NotFoundException {
        System.out.println("deleteCharacter");
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
        System.out.println("getCharacter");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL getCharacter(?)}");
            cStmt.setString(1, name);
            rs = cStmt.executeQuery();

            ArrayList<Character> c_list = new ArrayList<>();
            while (rs.next()) {
                Character c = new Character();
                c.setName(rs.getString("name"));
                c.setHeight(rs.getInt("height"));
                c.setMass(rs.getBigDecimal("mass"));
                c.setHairColor(rs.getString("hair_color"));
                c.setSkinColor(rs.getString("skin_color"));
                c.setEyeColor(rs.getString("eye_color"));
                c.setBirthYear(rs.getString("birth_year"));
                c.setGender(rs.getString("gender"));
                c.setHomeworld(rs.getString("homeworld"));
                c.setSpecies(rs.getString("species"));
                c_list.add(c);
                System.out.println(
                    c.getName()+", "+
                    c.getHeight()+", "+
                    c.getMass()+", "+
                    c.getHairColor()+", "+
                    c.getSkinColor()+", "+
                    c.getEyeColor()+", "+
                    c.getBirthYear()+", "+
                    c.getGender()+", "+
                    c.getHomeworld()+", "+
                    c.getSpecies()
                );
            }
            if(c_list.size() < 1){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok().entity(c_list.get(0)).build();
        } catch (SQLException ex) {
            return HelperFunctions.HandleError(ex);
        }
    }
    @Override
    public Response getMass(Integer mass, SecurityContext securityContext) throws NotFoundException {
        System.out.println("getMass");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL getMass(?)}");
            cStmt.setInt(1, mass);
            rs = cStmt.executeQuery();

            ArrayList<String> name_list = new ArrayList<>();
            while (rs.next()) {
                name_list.add(rs.getString("name"));
                System.out.println(rs.getString("name"));
            }
            if(name_list.size() < 1){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok().entity(name_list).build();
        } catch (SQLException ex) {
            return HelperFunctions.HandleError(ex);
        }
    }
    @Override
    public Response updateCharacter(Character body, SecurityContext securityContext) throws NotFoundException {
        System.out.println("updateCharacter");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());

            CallableStatement cStmt = conn.prepareCall("{CALL updateCharacter(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
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

            int updated = cStmt.executeUpdate();
            if(updated >= 1){
                return Response.status(Response.Status.OK).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException ex) {
            return HelperFunctions.HandleError(ex);
        }
    }
}
