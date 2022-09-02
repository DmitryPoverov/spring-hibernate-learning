package ru.clevertec.spring.specialist._03_dependencyInjection.implementations;

import ru.clevertec.spring.specialist._03_dependencyInjection.interfaces.Door;

public class WoodDoor implements Door {
    @Override
    public void install() {
        System.out.println("Install a wood door");
    }
}
