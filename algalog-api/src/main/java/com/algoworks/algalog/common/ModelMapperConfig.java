package com.algoworks.algalog.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //É um componente spring com o objetivo de configuração de beans
public class ModelMapperConfig {

    @Bean //Ele inicializa e configura um bean que será gerenciado pelo spring e portanto disponibilizado para usar em outras classes;
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
