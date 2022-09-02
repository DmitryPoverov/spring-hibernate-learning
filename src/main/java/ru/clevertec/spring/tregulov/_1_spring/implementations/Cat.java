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
@Component("catBean")
@Scope("singleton")
public class Cat implements Pet {

    public Cat() {
        System.out.println("Cat constructor");
    }

    @Override
    public void say() {
        System.out.println("- Meow-Meow.");
    }

    @PostConstruct
    public void methodForInit() {
        System.out.println("Cat init method");
    }

    @PreDestroy
    public void methodForDestroy() {
        System.out.println("Cat destroy method");
    }
}
