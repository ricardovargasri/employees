package com.ecodeuo.jdbc.dao;

import com.ecodeuo.jdbc.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    //Listar todos los empleados
    List<Employee> findAll();


    // hallar un empleado por ID
    Employee findById(Long id);

    // encontrar un empleado por edad
    List<Employee> findByAge(Integer age);

    // crear un empleado
    Employee create(Employee employee);

    // modificar un empleado

    Employee update(Employee employee);

    // borrar un empleado

    Boolean delete(Long id);
}
