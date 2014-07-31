package com.aimprosoft.jobs.service.impl;

import com.aimprosoft.jobs.dao.EmployeeDAO;
import com.aimprosoft.jobs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 17.12.13.
 */
@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;


}
