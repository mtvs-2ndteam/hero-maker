package com.contrabass.heromaker.configuration;

import com.contrabass.heromaker.application.dto.UserDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.contrabass.heromaker")
public class UserConfiguration {
    @Bean
    UserDTO userDTO() {
        return new UserDTO();
    }
}
