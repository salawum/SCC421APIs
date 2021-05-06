package io.swagger.api.factories;

import io.swagger.api.SpeciesApiService;
import io.swagger.api.impl.SpeciesApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public class SpeciesApiServiceFactory {
    private final static SpeciesApiService service = new SpeciesApiServiceImpl();

    public static SpeciesApiService getSpeciesApi() {
        return service;
    }
}
