package ru.clevertec.spring.specialist._02_appConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.clevertec.spring.specialist._01_xml.PersonBean;

public class SpringAppMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppContext.class);

/*The second way: empty constructor and register() to register class.
        AnnotationConfigApplicationContext context2 =
                new AnnotationConfigApplicationContext();
        context2.register(AppContext.class);
*/
        PersonBean person = context.getBean(PersonBean.class);
        System.out.printf("Person: %s - %d", person.getName(), person.getAge());

        context.close();
    }
}
