package ru.clevertec.hibernate.tregulov._6_ManyToMany.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tregulov_children")
public class Children {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;


}
