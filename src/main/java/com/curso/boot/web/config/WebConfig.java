package com.curso.boot.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.curso.boot.web.conversor.StringToCargoConverter; // Adicionar import
import com.curso.boot.web.conversor.StringToDepartamentoConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private StringToDepartamentoConverter stringToDepartamentoConverter;

    @Autowired // Adicionar injeção do novo conversor
    private StringToCargoConverter stringToCargoConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToDepartamentoConverter);
        registry.addConverter(stringToCargoConverter); // Registrar o novo conversor
    }
}