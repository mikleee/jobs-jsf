package com.aimprosoft.jobs.service.impl;

import com.aimprosoft.jobs.dao.EmployeeDAO;
import com.aimprosoft.jobs.model.Employee;
import com.aimprosoft.jobs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created on 17.12.13.
 */
@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeDAO.findAll();
    }


}
