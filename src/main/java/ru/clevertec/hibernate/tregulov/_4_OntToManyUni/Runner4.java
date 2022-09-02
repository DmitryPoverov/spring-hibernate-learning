package ru.clevertec.hibernate.tregulov._4_OntToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.clevertec.hibernate.tregulov._4_OntToManyUni.entity.*;

public class Runner4 {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(EmployeeUni.class);
        configuration.addAnnotatedClass(DepartmentUni.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {

            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                
/* To create a new department and two new users, and then save department and all users *
                DepartmentUni department = DepartmentUni.builder()
                        .departmentName("Network")
                        .maxSalary(1450)
                        .minSalary(500)
                        .build();
                EmployeeUni marge = EmployeeUni.builder()
                        .firstName("Marge")
                        .lastName("Simpson")
                        .salary(950)
                        .build();
                EmployeeUni homer = EmployeeUni.builder()
                        .firstName("Homer")
                        .lastName("Simpson")
                        .salary(450)
                        .build();
                department.addEmployeeToDepartment(marge);
                department.addEmployeeToDepartment(homer);
                session.save(department);*/

/* To get a department and all its employees *
                DepartmentUni department = session.get(DepartmentUni.class, 8L);
                System.out.println(department);
                department.getEmployeeUniList().forEach(System.out::println);*/

/* To delete one employee without his department *
                EmployeeUni employee = session.get(EmployeeUni.class, 2L);
                session.delete(employee);*/

/* To delete a department and its all employees (thanks for cascade=cascadeType.ALL)*
                DepartmentUni department = session.get(DepartmentUni.class, 2L);
                session.delete(department);*/

                session.getTransaction().commit();
            }
        }
    }
}
