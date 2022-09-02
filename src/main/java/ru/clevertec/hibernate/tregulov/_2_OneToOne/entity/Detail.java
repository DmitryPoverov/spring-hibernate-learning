package ru.clevertec.hibernate.tregulov._2_OneToOne.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tregulov_details")

public class Detail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "detail", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Employee employee;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return city.equals(detail.city) && phoneNumber.equals(detail.phoneNumber) && email.equals(detail.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, phoneNumber, email);
    }
}
