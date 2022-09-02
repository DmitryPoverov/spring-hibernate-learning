package ru.clevertec.spring.tregulov._1_spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.clevertec.spring.tregulov._1_spring.implementations.Person;

public class AnimalRunner {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("tregulov_Context.xml");

        Person person = context.getBean("petPersonBean", Person.class);
        person.callPet();

        System.out.println(person);

        context.close();
    }
}
