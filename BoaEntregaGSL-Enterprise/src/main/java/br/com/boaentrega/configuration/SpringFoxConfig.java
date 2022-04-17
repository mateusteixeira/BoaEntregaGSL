package br.com.boaentrega.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Boa Entrega GSL - Enterprise",
                "Módulo Enterprise",
                "1.0.0",
                "Terms of service",
                new Contact("Mateus Felipe Teixeira", "https://www.linkedin.com/in/mateus-felipe-teixeira-7ab5747a/", "mateusteixeira_@hotmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.boaentrega.api"))
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