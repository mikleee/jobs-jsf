package com.aimprosoft.jobs.controller;

import com.aimprosoft.jobs.model.Employee;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 * @author Mikhail Tkachenko
 */
@ManagedBean
@SessionScoped
@Component
public class SingleEmployee extends BaseManagedBean {

    private Employee singleEmployee;


    public Employee getSingleEmployee() {
        return singleEmployee;
    }

    public void setSingleEmployee(Employee singleEmployee) {
        this.singleEmployee = singleEmployee;
    }


    public void showEmployeeInfo(AjaxBehaviorEvent event) {
        Object id = ((javax.faces.component.html.HtmlSelectOneMenu) event.getSource()).getValue();
        singleEmployee = employeeService.findOne(Integer.valueOf((String) id));
    }


}
