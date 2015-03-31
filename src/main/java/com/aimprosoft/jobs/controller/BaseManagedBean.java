package com.aimprosoft.jobs.controller;

import com.aimprosoft.jobs.service.DepartmentService;
import com.aimprosoft.jobs.service.EmployeeService;
import com.aimprosoft.jobs.service.impl.DepartmentServiceImpl;
import com.aimprosoft.jobs.service.impl.EmployeeServiceImpl;
import com.aimprosoft.jobs.utils.SpringUtils;

import java.io.Serializable;

/**
 * @author Mikhail Tkachenko
 */
public class BaseManagedBean implements Serializable {

    protected DepartmentService departmentService = SpringUtils.getBean(DepartmentServiceImpl.class);
    protected EmployeeService employeeService = SpringUtils.getBean(EmployeeServiceImpl.class);

}
