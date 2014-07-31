package com.aimprosoft.jobs.controller;

import com.aimprosoft.jobs.model.Department;
import com.aimprosoft.jobs.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Tkachenko
 */
@ManagedBean
@SessionScoped
@Component
public class SingleDepartment extends BaseManagedBean implements AjaxHandler {

    private Department singleDepartment;


    public Department getSingleDepartment() {
        return singleDepartment;
    }


    public void setSingleDepartment(Department singleDepartment) {
        this.singleDepartment = singleDepartment;
    }


    public List<SelectItem> getEmployees() {
        List<SelectItem> result = new ArrayList<>();

        for (Employee employee : singleDepartment.getEmployeeList()) {
            SelectItem selectItem = new SelectItem(employee.getId(), employee.getName());
            result.add(selectItem);
        }

        return result;
    }


    @Transactional
    public void handleEvent(AjaxBehaviorEvent event) {
        Object id = ((javax.faces.component.html.HtmlSelectOneMenu) event.getSource()).getValue();
        singleDepartment = departmentService.findOne(Integer.valueOf((String) id));
    }

}
