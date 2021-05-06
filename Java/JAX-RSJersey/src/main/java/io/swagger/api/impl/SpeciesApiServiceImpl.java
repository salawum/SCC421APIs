package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Species;
import io.swagger.model.SpeciesList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public class SpeciesApiServiceImpl extends SpeciesApiService {
    @Override
    public Response addSpecies(Species body, SecurityContext securityContext) throws NotFoundException {
        System.out.println("addSpecies");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL addSpecies(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            cStmt.setString(1, body.getName());
            cStmt.setString(2, body.getClassification());
            cStmt.setString(3, body.getDesignation());
            cStmt.setInt(4, body.getAverageHeight());
            cStmt.setString(5, body.getSkinColors());
            cStmt.setString(6, body.getHairColors());
            cStmt.setString(7, body.getEyeColors());
            cStmt.setString(8, body.getAverageLifespan());
            cStmt.setString(9, body.getLanguage());
            cStmt.setString(10, body.getHomeworld());

            rs = cStmt.executeQuery();
        } catch (SQLException ex) {
            return HelperFunctions.HandleError(ex);
        }
        return Response.ok().entity(body).build();
    }
    @Override
    public Response deleteSpecies(String name, SecurityContext securityContext) throws NotFoundException {
        System.out.println("deleteSpecies");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL deleteSpecies(?)}");
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
    public Response getEyeColor(String eyeColor, SecurityContext securityContext) throws NotFoundException {
        System.out.println("getEyeColor");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL getEyeColor(?)}");
            cStmt.setString(1, eyeColor);
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
    public Response getSpecies(String name, SecurityContext securityContext) throws NotFoundException {
        System.out.println("getSpecies");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL getSpecies(?)}");
            cStmt.setString(1, name);
            rs = cStmt.executeQuery();

            ArrayList<Species> s_list = new ArrayList<>();
            while (rs.next()) {
                Species s = new Species();
                s.setName(rs.getString("name"));
                s.setClassification(rs.getString("classification"));
                s.setDesignation(rs.getString("designation"));
                s.setAverageHeight(rs.getInt("average_height"));
                s.setHairColors(rs.getString("hair_colors"));
                s.setSkinColors(rs.getString("skin_colors"));
                s.setEyeColors(rs.getString("eye_colors"));
                s.setAverageLifespan(rs.getString("average_lifespan"));
                s.setLanguage(rs.getString("language"));
                s.setHomeworld(rs.getString("homeworld"));
                s_list.add(s);
                System.out.println(
                    s.getName()+", "+
                    s.getClassification()+", "+
                    s.getDesignation()+", "+
                    s.getAverageHeight()+", "+
                    s.getHairColors()+", "+
                    s.getSkinColors()+", "+
                    s.getEyeColors()+", "+
                    s.getAverageLifespan()+", "+
                    s.getLanguage()+", "+
                    s.getHomeworld()
                );
            }
            if(s_list.size() < 1){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok().entity(s_list.get(0)).build();
        } catch (SQLException ex) {
            return HelperFunctions.HandleError(ex);
        }
    }
    @Override
    public Response updateSpecies(Species body, SecurityContext securityContext) throws NotFoundException {
        System.out.println("updateSpecies");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL updateSpecies(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            cStmt.setString(1, body.getName());
            cStmt.setString(2, body.getClassification());
            cStmt.setString(3, body.getDesignation());
            cStmt.setInt(4, body.getAverageHeight());
            cStmt.setString(5, body.getSkinColors());
            cStmt.setString(6, body.getHairColors());
            cStmt.setString(7, body.getEyeColors());
            cStmt.setString(8, body.getAverageLifespan());
            cStmt.setString(9, body.getLanguage());
            cStmt.setString(10, body.getHomeworld());

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
