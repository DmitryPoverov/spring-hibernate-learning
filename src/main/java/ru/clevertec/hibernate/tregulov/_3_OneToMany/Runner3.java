package ru.clevertec.hibernate.tregulov._3_OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.clevertec.hibernate.tregulov._3_OneToMany.entity.Department;
import ru.clevertec.hibernate.tregulov._3_OneToMany.entity.Employee;

public class Runner3 {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Department.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

/* To create a new department and two new users, and then save department and all users *
                Department department = Department.builder()
                        .departmentName("QA")
                        .maxSalary(1250)
                        .minSalary(500)
                        .build();
                Employee patty = Employee.builder()
                        .firstName("Patty")
                        .lastName("Bouvier")
                        .salary(1250)
                        .department(department)
                        .build();
                Employee salma = Employee.builder()
                        .firstName("Salma")
                        .lastName("Bouvier")
                        .salary(1250)
                        .department(department)
                        .build();
                department.addEmployeeToDepartment(patty);
                department.addEmployeeToDepartment(salma);
                session.save(department);*/

/* To get a department and its all users *
                Department department = session.get(Department.class, 4L);
                department.getEmployeeList().forEach(System.out::println);*/

/* To get a user his department *
                Employee employee = session.get(Employee.class, 4L);
                System.out.println(employee.getDepartment());*/

/* To delete a user without his department *
                Employee employee = session.get(Employee.class, 7L);
                session.delete(employee);*/

                session.getTransaction().commit();
            }
        }
    }
}
