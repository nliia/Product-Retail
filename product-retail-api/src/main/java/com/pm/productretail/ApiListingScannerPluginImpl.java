package com.pm.productretail;

import com.fasterxml.classmate.TypeResolver;
import com.pm.productretail.dto.SignInDto;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingScannerPlugin;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lnurullina
 */
@Component
public class ApiListingScannerPluginImpl implements ApiListingScannerPlugin {
    private static final String REQUEST_EXAMPLE = "{\n" +
            "  \"password\": \"string\",\n" +
            "  \"username\": \"string\"\n" +
            "}";

    @Override
    public List<ApiDescription> apply(DocumentationContext context) {
        return new ArrayList<>(
                Arrays.asList(
                        new ApiDescription(
                                "/sign_in",
                                "Get token for login",
                                Arrays.asList(
                                        new OperationBuilder(
                                                new CachingOperationNameGenerator())
                                                .authorizations(new ArrayList())
                                                .codegenMethodNameStem("basicAuth0001")
                                                .method(HttpMethod.POST)
                                                .parameters(
                                                        Arrays.asList(
                                                                new ParameterBuilder()
                                                                        .description("Login")
                                                                        .type(new TypeResolver().resolve(SignInDto.class))
                                                                        .name("Authorization")
                                                                        .parameterType("body")
                                                                        .parameterAccess("access")
                                                                        .hidden(true)
                                                                        .required(true)
                                                                        .modelRef(new ModelRef(REQUEST_EXAMPLE))
                                                                        .build())
                                                )
                                                .build()),
                                false)));
    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return DocumentationType.SWAGGER_2.equals(delimiter);
    }
}