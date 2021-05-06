package io.swagger.api.factories;

import io.swagger.api.PlanetApiService;
import io.swagger.api.impl.PlanetApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public class PlanetApiServiceFactory {
    private final static PlanetApiService service = new PlanetApiServiceImpl();

    public static PlanetApiService getPlanetApi() {
        return service;
    }
}
