package com.aimprosoft.jobs.service;

import com.aimprosoft.jobs.model.Employee;

import java.util.List;

/**
 * Created on 12/23/13.
 */
public interface EmployeeService {

    List<Employee> findAll();

    Employee findOne(Integer id);
}
