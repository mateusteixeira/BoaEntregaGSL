package br.com.boaentregadata.configuration;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.Instant;
import java.util.*;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Boa Entrega GSL - Data",
                "Módulo Data",
                "1.0.0",
                "Terms of service",
                new Contact("Mateus Felipe Teixeira", "https://www.linkedin.com/in/mateus-felipe-teixeira-7ab5747a/", "mateusteixeira_@hotmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    @Bean
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .alternateTypeRules(AlternateTypeRules.newRule(
                        typeResolver.resolve(Collection.class, Instant.class),
                        typeResolver.resolve(Collection.class, Date.class), Ordered.HIGHEST_PRECEDENCE))
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.boaentregadata.api"))
                .paths(PathSelectors.any())
                .build()
                .host("localhost")
                .globalResponseMessage(RequestMethod.GET, responseMessageFor())
                .globalResponseMessage(RequestMethod.POST, responseMessageFor())
                .globalResponseMessage(RequestMethod.PUT, responseMessageFor())
                .globalResponseMessage(RequestMethod.DELETE, responseMessageFor());
    }

    private List<ResponseMessage> responseMessageFor() {
        return new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder()
                    .code(500)
                    .message("Internal Server Error")
                    .responseModel(new ModelRef("Error"))
                    .build());
            add(new ResponseMessageBuilder()
                    .code(403)
                    .message("Forbidden!")
                    .build());
            add(new ResponseMessageBuilder()
                    .code(404)
                    .message("Not Found!")
                    .build());
        }};
    }
}