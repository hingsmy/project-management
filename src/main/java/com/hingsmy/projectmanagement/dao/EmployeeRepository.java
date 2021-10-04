package com.hingsmy.projectmanagement.dao;

import com.hingsmy.projectmanagement.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();
}
