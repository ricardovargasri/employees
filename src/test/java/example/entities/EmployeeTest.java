package example.entities;

import com.ecodeuo.jdbc.entities.Car;
import com.ecodeuo.jdbc.entities.Employee;
import com.ecodeuo.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeTest {

    @Test
    void createTableTest (){


        Employee employee1 = new Employee(
                null,
                "ricardo",
                "vargas",
                "piscu@email.com",
                30,
                100.5,
                true,
                LocalDate.of(1995, 04, 29),
                LocalDateTime.now());
        Employee employee2 = new Employee(
                null,
                "laura",
                "fernandez",
                "laura.fernandez@email.com",
                28,
                65.0,
                false,
                LocalDate.of(1996, 11, 15),
                LocalDateTime.now());

        Car car1 = new Car(
                null,
                "mazeratti",
                "nuevesito",
                "understand",
                2024,
                4587.25,
                false,
                LocalDate.of(1996, 11, 15)
        );
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(employee1);
        session.save(employee2);

        session.save(car1);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
