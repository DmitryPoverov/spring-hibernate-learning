package ru.clevertec.spring.tregulov._1_spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.clevertec.spring.tregulov._1_spring.implementations.Cat;
import ru.clevertec.spring.tregulov._1_spring.implementations.Dog;
import ru.clevertec.spring.tregulov._1_spring.implementations.Person;
import ru.clevertec.spring.tregulov._1_spring.interfaces.Pet;

public class AnnotationRunner {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("tregulov_Annotation.xml");

        Person person = context.getBean("personAnnotationBean", Person.class);
        person.callPet();
        System.out.println(person);

        Dog pet = context.getBean("dogBean", Dog.class);
        Dog pet1 = context.getBean("dogBean", Dog.class);
        Cat pet2 = context.getBean("catBean", Cat.class);
        Cat pet3 = context.getBean("catBean", Cat.class);

        pet.say();
        pet1.say();
        pet2.say();
        pet3.say();

        System.out.println(pet.hashCode());
        System.out.println(pet1.hashCode());
        System.out.println(pet2.hashCode());
        System.out.println(pet3.hashCode());

        context.close();
    }
}
