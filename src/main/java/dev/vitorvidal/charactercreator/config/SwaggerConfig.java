package dev.vitorvidal.charactercreator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("Character creator API")
                                .version("1.0")
                                .build()
                )
                .enable(true)
                .select()
                .paths(PathSelectors.any())
                .build();
    }
}
