package ru.clevertec.spring.specialist._03_dependencyInjection.implementations;

import ru.clevertec.spring.specialist._03_dependencyInjection.interfaces.Material;

public class Wood implements Material {

    @Override
    public void cover() {
        System.out.println("Lay timbers");
    }
}
