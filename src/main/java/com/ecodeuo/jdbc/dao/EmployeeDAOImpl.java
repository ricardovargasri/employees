package com.ecodeuo.jdbc.dao;

import com.ecodeuo.jdbc.entities.Employee;
import com.ecodeuo.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Employee", Employee.class);

        List<Employee> employees = query.list();
        session.close();

        return employees;
    };

    @Override
    public Employee findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = session.find(Employee.class, id);
        session.close();

        return employee;
    }

    @Override
    public List<Employee> findByAge(Integer age) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Employee> query = session.createQuery("from Employee where age = :age", Employee.class);
        query.setParameter("age", age);
        List<Employee> employees = query.list();
        session.close();
        return employees;
    }

    @Override
    public Employee create(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
        return employee;
    }

    @Override
    public Employee update(Employee employee) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
        return employee;
    }



    @Override
    public Boolean delete(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Employee employee = new Employee();
            employee.setId(id);
            session.delete(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        finally {
            session.close();
        }

        session.close();
        return true;
    }

}
