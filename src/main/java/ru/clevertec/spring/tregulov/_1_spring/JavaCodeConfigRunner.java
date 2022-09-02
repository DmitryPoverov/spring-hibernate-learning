package ru.clevertec.spring.tregulov._1_spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.clevertec.spring.tregulov._1_spring.implementations.Person;
import ru.clevertec.spring.tregulov._1_spring.interfaces.Pet;

public class JavaCodeConfigRunner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfigApp.class);

        Person person = context.getBean("personAnnotationBean", Person.class);
        person.callPet();
        System.out.println(person);

        context.close();


        AnnotationConfigApplicationContext context1 =
                new AnnotationConfigApplicationContext(SpringConfigJavaCodeApp.class);

        Pet cat1 = context1.getBean("catBeanJavaApp", Pet.class);
        Pet cat2 = context1.getBean("catBeanJavaApp", Pet.class);
        cat1.say();
        cat2.say();
        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());

        Person person1 = context1.getBean("personBeanJavaApp", Person.class);
        person1.callPet();

        context1.close();
    }
}
