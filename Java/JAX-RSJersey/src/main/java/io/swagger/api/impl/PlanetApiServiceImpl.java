package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Planet;
import io.swagger.model.PlanetList;

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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public class PlanetApiServiceImpl extends PlanetApiService {
    @Override
    public Response addPlanet(Planet body, SecurityContext securityContext) throws NotFoundException {
        System.out.println("addPlanet");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL addPlanet(?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            cStmt.setString(1, body.getName());
            cStmt.setBigDecimal(2, body.getRotationPeriod());
            cStmt.setBigDecimal(3, body.getOrbitalPeriod());
            cStmt.setInt(4, body.getDiameter());
            cStmt.setString(5, body.getClimate());
            cStmt.setString(6, body.getGravity());
            cStmt.setString(7, body.getTerrain());
            cStmt.setBigDecimal(8, body.getSurfaceWater());
            cStmt.setInt(9, body.getPopulation());

            rs = cStmt.executeQuery();
        } catch (SQLException ex) {
            return HelperFunctions.HandleError(ex);
        }
        return Response.ok().entity(body).build();
    }
    @Override
    public Response deletePlanet(String name, SecurityContext securityContext) throws NotFoundException {
        System.out.println("deletePlanet");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL deletePlanet(?)}");
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
    public Response getPlanet(String name, SecurityContext securityContext) throws NotFoundException {
        System.out.println("getPlanet");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL getPlanet(?)}");
            cStmt.setString(1, name);
            rs = cStmt.executeQuery();

            ArrayList<Planet> p_list = new ArrayList<>();
            while (rs.next()) {
                Planet p = new Planet();
                p.setName(rs.getString("name"));
                p.setRotationPeriod(rs.getBigDecimal("rotation_period"));
                p.setOrbitalPeriod(rs.getBigDecimal("orbital_period"));
                p.setDiameter(rs.getInt("diameter"));
                p.setClimate(rs.getString("climate"));
                p.setGravity(rs.getString("gravity"));
                p.setTerrain(rs.getString("terrain"));
                p.setSurfaceWater(rs.getBigDecimal("surface_water"));
                p.setPopulation(rs.getInt("population"));
                p_list.add(p);
                System.out.println(
                    p.getName()+", "+
                    p.getRotationPeriod()+", "+
                    p.getOrbitalPeriod()+", "+
                    p.getDiameter()+", "+
                    p.getClimate()+", "+
                    p.getGravity()+", "+
                    p.getTerrain()+", "+
                    p.getSurfaceWater()+", "+
                    p.getPopulation()
                );
            }
            if(p_list.size() < 1){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok().entity(p_list.get(0)).build();
        } catch (SQLException ex) {
            return HelperFunctions.HandleError(ex);
        }
    }
    @Override
    public Response getTerrain(String terrain, SecurityContext securityContext) throws NotFoundException {
        System.out.println("getTerrain");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL getTerrain(?)}");
            cStmt.setString(1, terrain);
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
    public Response getUninhabited(SecurityContext securityContext) throws NotFoundException {
        System.out.println("getUninhabited");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL getUninhabited()}");
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
    public Response updatePlanet(Planet body, SecurityContext securityContext) throws NotFoundException {
        System.out.println("updatePlanet");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(HelperFunctions.getConnectionString());
            CallableStatement cStmt = conn.prepareCall("{CALL updatePlanet(?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            cStmt.setString(1, body.getName());
            cStmt.setBigDecimal(2, body.getRotationPeriod());
            cStmt.setBigDecimal(3, body.getOrbitalPeriod());
            cStmt.setInt(4, body.getDiameter());
            cStmt.setString(5, body.getClimate());
            cStmt.setString(6, body.getGravity());
            cStmt.setString(7, body.getTerrain());
            cStmt.setBigDecimal(8, body.getSurfaceWater());
            cStmt.setInt(9, body.getPopulation());

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
