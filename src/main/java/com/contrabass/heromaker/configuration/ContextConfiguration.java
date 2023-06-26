package com.contrabass.heromaker.configuration;

import com.contrabass.heromaker.application.dto.CharacterDTO;
import com.contrabass.heromaker.application.dto.UserDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.contrabass.heromaker")
public class ContextConfiguration {
    @Bean
    UserDTO userDTO() {
        return new UserDTO();
    }

    @Bean
    CharacterDTO characterDTO() {
        return new CharacterDTO();
    }

}
