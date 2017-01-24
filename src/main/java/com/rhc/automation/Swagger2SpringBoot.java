package com.rhc.automation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rhc.automation.config.JacksonMapperBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.rhc.automation")
public class Swagger2SpringBoot implements CommandLineRunner {

    @Override
    public void run( String... arg0 ) throws Exception {
        if ( arg0.length > 0 && arg0[0].equals( "exitcode" ) ) {
            throw new ExitException();
        }
    }

    public static void main( String[] args ) throws Exception {
        new SpringApplication( Swagger2SpringBoot.class ).run( args );
    }

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        return JacksonMapperBuilder.get();
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}