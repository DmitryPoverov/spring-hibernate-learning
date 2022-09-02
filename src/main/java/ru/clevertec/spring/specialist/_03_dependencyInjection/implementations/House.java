package ru.clevertec.spring.specialist._03_dependencyInjection.implementations;

import lombok.Getter;
import lombok.Setter;
import ru.clevertec.spring.specialist._03_dependencyInjection.interfaces.Door;
import ru.clevertec.spring.specialist._03_dependencyInjection.interfaces.Material;
import ru.clevertec.spring.specialist._03_dependencyInjection.interfaces.Window;

import java.util.Map;

@Getter
@Setter
public class House {

    private Window window;
    private int height;
    private Material wall;
    private Map<String, Door> doors;

    public House(Window window) {
        this.window = window;
    }

    public void view() {
        window.open();
    }

    public void buildWall() {
        for (int i=0; i<getHeight();) {
            System.out.printf("Floor %d: ", ++i);
            getWall().cover();
        }
    }

    public void installDoors() {
        for (Map.Entry<String, Door> entry : doors.entrySet()) {
            System.out.printf("Key %s. ", entry.getKey());
            entry.getValue().install();
        }
    }
}
