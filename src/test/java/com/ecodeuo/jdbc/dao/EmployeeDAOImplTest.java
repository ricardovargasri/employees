package com.ecodeuo.jdbc.dao;

import com.ecodeuo.jdbc.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOImplTest {

    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();


    @Test
    void findAll() {

        List<Employee> employees = employeeDAO.findAll();
        System.out.println(employees);
    }
    EmployeeDAO dao;
    @BeforeEach
    void setUp() {
        dao = new EmployeeDAOImpl();
    }
    @Test
    void findById() {
        Employee employee1 = dao.findById(1L);
        Employee employee2 = dao.findById(2L);
        Employee employee3 = dao.findById(3L);
    }


    @Test
    void findByAge() {
        List<Employee> employee28 = dao.findByAge(28);

    }

    @Test
    void create() {
        Employee employee = new Employee(
                null,
                "Carlos",
                "Baca",
                "bucaracara@email.com",
                78,
                8488.2,
                false,
                LocalDate.of(1980, 5, 12),
                LocalDateTime.now()
                );
        employee = dao.create(employee);
        System.out.println(employee);
    }

    @Test
    void update() {

        Employee employee1 = new Employee(
                3L,
                "Carlos editado",
                "Baca",
                "bucaracara@email.com",
                85,
                8488.2,
                false,
                LocalDate.of(1980, 5, 12),
                LocalDateTime.now()
        );
        employee1 = dao.update(employee1);

        System.out.println(employee1);
    }

    @Test
    void delete() {
        Boolean result = dao.delete(1L);
        System.out.println(result);

    }
}