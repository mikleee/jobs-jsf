package com.aimprosoft.jobs.controller;

import com.aimprosoft.jobs.service.DepartmentService;
import com.aimprosoft.jobs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Mikhail Tkachenko
 */
@Component
public class BaseManagedBean implements Serializable {

    @Autowired
    protected DepartmentService departmentService;

    @Autowired
    protected EmployeeService employeeService;

}
