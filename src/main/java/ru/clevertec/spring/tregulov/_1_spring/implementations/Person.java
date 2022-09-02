package ru.clevertec.spring.tregulov._1_spring.implementations;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.clevertec.spring.tregulov._1_spring.interfaces.Pet;

@Setter
@Getter
@ToString
@Component("personAnnotationBean")
public class Person {

    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

/* Пример авто связывания и уточнения для конструктора.*/
    @Autowired
    public Person(@Qualifier("dogBean") Pet pet) {
        this.pet = pet;
    }

/* Пример авто связывания и уточнения для сеттера.
    @Autowired
    @Qualifier("catBean")*/
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void callPet() {
        System.out.println("- Hi, pet.");
        getPet().say();
    }
}
