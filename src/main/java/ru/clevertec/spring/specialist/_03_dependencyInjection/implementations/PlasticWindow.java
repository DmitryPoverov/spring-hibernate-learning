package ru.clevertec.spring.specialist._03_dependencyInjection.implementations;

import ru.clevertec.spring.specialist._03_dependencyInjection.interfaces.Window;

public class PlasticWindow implements Window {

    @Override
    public void open() {
        System.out.println("### Plastic window is open ###");
    }
}
