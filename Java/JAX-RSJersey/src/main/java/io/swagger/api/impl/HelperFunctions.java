package io.swagger.api.impl;

import io.github.cdimascio.dotenv.Dotenv;
import io.swagger.api.ApiResponseMessage;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public abstract class HelperFunctions {
    public static String getConnectionString(){
        Dotenv dotenv = Dotenv.configure()
                .directory("./")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
        return "jdbc:mysql://"+dotenv.get("DB_HOST")+
                "/"+dotenv.get("DB_DATABASE")+
                "?user="+dotenv.get("DB_USER")+
                "&password="+dotenv.get("DB_PWD");
    }

    public static Response HandleError(SQLException ex){
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
        switch(ex.getErrorCode()) {
            case 1062:
            case 1452:
                return Response.status(Response.Status.CONFLICT).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Conflict")).build();
            case 1046:
                return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Not Found")).build();
            default:
                return Response.status(Response.Status.BAD_REQUEST).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Bad Request")).build();
        }
    }
}
