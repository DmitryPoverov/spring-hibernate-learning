package ru.clevertec.spring.tregulov._1_spring.implementations;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.clevertec.spring.tregulov._1_spring.interfaces.Pet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Setter
@Getter
@ToString
@Component("dogBean")
@Scope("prototype")
public class Dog implements Pet {

    public Dog() {
        System.out.println("Dog constructor");
    }

    @Override
    public void say() {
        System.out.println("- Bow-Wow.");
    }

    @PostConstruct
    public void methodForInit() {
        System.out.println("Dog init method");
    }

    @PreDestroy
    public void methodForDestroy() {
        System.out.println("Dog destroy method");
    }
}

