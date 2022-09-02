package ru.clevertec.hibernate.tregulov._5_OneToManyLoadingTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.clevertec.hibernate.tregulov._5_OneToManyLoadingTypes.entity.*;

public class Runner5 {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee5.class);
        configuration.addAnnotatedClass(Department5.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

/* To create a new department and three new users, and then save department and all users *
                Department5 department = Department5.builder()
                        .departmentName("Sales")
                        .maxSalary(1000)
                        .minSalary(400)
                        .build();
                Employee5 jannet = Employee5.builder()
                        .firstName("Jannet")
                        .lastName("Canton")
                        .salary(750)
                        .department(department)
                        .build();
                Employee5 sasha = Employee5.builder()
                        .firstName("Sasha")
                        .lastName("Stayer")
                        .salary(800)
                        .department(department)
                        .build();
                Employee5 sassy = Employee5.builder()
                        .firstName("Sassy")
                        .lastName("Say")
                        .salary(500)
                        .department(department)
                        .build();
                department.addEmployeeToDepartment(jannet);
                department.addEmployeeToDepartment(sasha);
                department.addEmployeeToDepartment(sassy);
                session.save(department);*/

/* To delete a user without his department */
                Department5 department = session.get(Department5.class, 10L);
                System.out.println(department);
                department.getEmployeeList().forEach(System.out::println);

                session.getTransaction().commit();
            }
        }
    }
}
