package org.smartinrubio.spring5webapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"org.smartinrubio.spring5webapp"},
        excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
@Import(WebConfig.class)
public class RootConfig {
}
