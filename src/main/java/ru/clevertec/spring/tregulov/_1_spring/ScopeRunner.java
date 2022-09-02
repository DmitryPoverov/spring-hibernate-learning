package ru.clevertec.spring.tregulov._1_spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.clevertec.spring.tregulov._1_spring.interfaces.Pet;

public class ScopeRunner {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("tregulov_TestContext.xml");

        Pet pet1 = context.getBean("scopePet1Bean", Pet.class);
        Pet pet2 = context.getBean("scopePet2Bean", Pet.class);

        pet1.say();
        pet2.say();

        context.close();
    }
}
