package ru.clevertec.spring.specialist._01_xml;

import lombok.*;

//It's POJO - Plain Old Java Object
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PersonBean {

    private String name;
    private int age;

    // I changed the order of the fields and so i needed to change the order in the xml-file
    public PersonBean(int age, String name) {
        this.name = name;
        this.age = age;
    }
}
