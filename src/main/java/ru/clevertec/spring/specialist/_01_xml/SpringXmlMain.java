package ru.clevertec.spring.specialist._01_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfigs.xml");
        PersonBean person1 = context.getBean("beanForPerson_AllArgs", PersonBean.class);
        System.out.printf("Person1: %s - %d\n", person1.getName(), person1.getAge());

        PersonBean person2 = context.getBean("beanForPerson_NoArgs", PersonBean.class);
        person2.setName("Bob_Main");
        person2.setAge(18);
        System.out.printf("Person2: %s - %d\n", person2.getName(), person2.getAge());

        context.close();
    }
}
