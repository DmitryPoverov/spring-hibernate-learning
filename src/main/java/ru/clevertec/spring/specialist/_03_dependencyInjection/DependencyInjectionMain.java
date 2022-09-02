package ru.clevertec.spring.specialist._03_dependencyInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.clevertec.spring.specialist._03_dependencyInjection.implementations.Brick;
import ru.clevertec.spring.specialist._03_dependencyInjection.implementations.House;

public class DependencyInjectionMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        House house = context.getBean("houseBean", House.class);
        house.buildWall();
        house.installDoors();
        house.view();
        System.out.printf("Number of floors: %d \n", house.getHeight());

        System.out.println(context.getBean("brickBean", Brick.class));
        System.out.println(context.getBean("brickBean", Brick.class));

        MainWindow window = context.getBean("mainWindowBean", MainWindow.class);
        window.show();

        context.close();
    }
}
