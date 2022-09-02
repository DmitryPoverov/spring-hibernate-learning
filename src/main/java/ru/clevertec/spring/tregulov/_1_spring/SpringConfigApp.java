package ru.clevertec.spring.tregulov._1_spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.clevertec.spring")
@PropertySource("classpath:tregulov_pet.properties")
public class SpringConfigApp {
}
