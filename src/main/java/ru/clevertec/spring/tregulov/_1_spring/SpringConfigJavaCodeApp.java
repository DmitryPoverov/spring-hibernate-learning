package ru.clevertec.spring.tregulov._1_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import ru.clevertec.spring.tregulov._1_spring.implementations.Cat;
import ru.clevertec.spring.tregulov._1_spring.implementations.Person;
import ru.clevertec.spring.tregulov._1_spring.interfaces.Pet;

@Configuration
@PropertySource("classpath:tregulov_pet.properties")
public class SpringConfigJavaCodeApp {

    @Bean
    @Scope("singleton")
    public Pet catBeanJavaApp() {
        return new Cat();
    }

    @Bean
    public Person personBeanJavaApp() {
        return new Person(catBeanJavaApp());
    }

}
