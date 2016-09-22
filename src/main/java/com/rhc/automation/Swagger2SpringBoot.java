package com.rhc.automation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.rhc.automation.service.CustomerService;
import com.rhc.automation.service.OpenShiftService;
import com.rhc.automation.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.rhc.automation")
public class Swagger2SpringBoot implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(Swagger2SpringBoot.class);

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    @Bean
    public CommandLineRunner startUp(UserService userService, OpenShiftService openShiftService,
            CustomerService customerService) {
        return (args) -> {
            
        };
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}