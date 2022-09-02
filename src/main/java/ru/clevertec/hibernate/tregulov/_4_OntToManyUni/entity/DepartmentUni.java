package ru.clevertec.hibernate.tregulov._4_OntToManyUni.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tregulov_departments")
public class DepartmentUni {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private long id;

    @Column(name = "name")
    private String departmentName;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

// One department to many employees
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    @ToString.Exclude
    private List<EmployeeUni> employeeUniList;



    public void addEmployeeToDepartment(EmployeeUni employeeUni) {
        if (employeeUniList == null) {
            employeeUniList = new ArrayList<>();
        }
        employeeUniList.add(employeeUni);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentUni that = (DepartmentUni) o;
        return departmentName.equals(that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName);
    }
}
