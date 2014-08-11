package com.aimprosoft.jobs;

import com.aimprosoft.jobs.dao.DepartmentDAO;
import com.aimprosoft.jobs.dao.EmployeeDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Mikhail Tkachenko
 */

@Component
public class Main {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/spring-main-config.xml");
    static DepartmentDAO departmentDAO = applicationContext.getBean("departmentDAO", DepartmentDAO.class);
    static EmployeeDAO employeeDAO = applicationContext.getBean("employeeDAO", EmployeeDAO.class);


    public static void main(String[] args) {

        Iterable iterable = employeeDAO.findAll();


    }


}
