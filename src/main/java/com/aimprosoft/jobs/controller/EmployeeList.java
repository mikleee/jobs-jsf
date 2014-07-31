package com.aimprosoft.jobs.controller;

import com.aimprosoft.jobs.model.Employee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Tkachenko
 */
@ManagedBean
@SessionScoped
public class EmployeeList extends BaseManagedBean {

    private List<SelectItem> employeeList;


    public List<SelectItem> getEmployeeList() {
        employeeList = new ArrayList<>();

        for (Employee employee : employeeService.findAll()) {
            SelectItem selectItem = new SelectItem(employee.getId(), employee.getName());
            employeeList.add(selectItem);
        }

        return employeeList;
    }


    public void setEmployeeList(List<SelectItem> employeeList) {
        this.employeeList = employeeList;
    }
}
