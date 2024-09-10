package dev.hexa.productservice.config;

import dev.hexa.productservice.application.annotation.DomainServiceAnnotation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "dev.hexa.productservice.application",
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        value = DomainServiceAnnotation.class
                )
        }

)
public class DomainConfig {
}
