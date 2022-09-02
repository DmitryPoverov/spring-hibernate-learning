package ru.clevertec.spring.specialist._03_dependencyInjection.implementations;

import ru.clevertec.spring.specialist._03_dependencyInjection.interfaces.Material;

public class Brick implements Material {

    @Override
    public void cover() {
        System.out.println("Lay the bricks" + this);
    }
}
