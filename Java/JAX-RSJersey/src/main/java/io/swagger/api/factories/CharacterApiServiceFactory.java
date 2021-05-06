package io.swagger.api.factories;

import io.swagger.api.CharacterApiService;
import io.swagger.api.impl.CharacterApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-04T14:46:54.785Z[GMT]")public class CharacterApiServiceFactory {
    private final static CharacterApiService service = new CharacterApiServiceImpl();

    public static CharacterApiService getCharacterApi() {
        return service;
    }
}
