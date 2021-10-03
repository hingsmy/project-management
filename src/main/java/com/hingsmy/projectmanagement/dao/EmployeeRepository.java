package com.hingsmy.projectmanagement.dao;

import com.hingsmy.projectmanagement.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
