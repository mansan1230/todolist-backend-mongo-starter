package com.afs.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfiguration {

    @Bean
    public WebMvcConfigurer webMvcConfig()
    {
        return  new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                    registry.addMapping("/**")
                            .allowedMethods("GET","POST","PUT","DELETE")
                            .allowedOrigins("http://localhost:3000");
                }
            };

        }
}

