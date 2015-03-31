package com.aimprosoft.jobs.controller;

import com.aimprosoft.jobs.model.Department;
import com.aimprosoft.jobs.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.ValueHolder;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Tkachenko
 */
@ManagedBean
@SessionScoped
public class SingleDepartment extends BaseManagedBean {

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

    private String r;

    public String getR() {
        return r;
    }

    public void makeRandom(AjaxBehaviorEvent event) {
        ValueHolder source = (ValueHolder) event.getSource();
        r = (String) source.getValue();
    }

    public void showDepartmentInfo(AjaxBehaviorEvent event) {
        Object id = ((javax.faces.component.html.HtmlSelectOneMenu) event.getSource()).getValue();
        singleDepartment = departmentService.findOne(Integer.valueOf((String) id));
        singleDepartment.getEmployeeList().size();
    }

    public void showAddForm(AjaxBehaviorEvent event) {
        singleDepartment = new Department();
    }

    public void saveDepartment(Integer id, String name, String location) {
        Department department = new Department(id == 0 ? null : id, name, location);
        singleDepartment = departmentService.save(department);
    }

    public void deleteDepartment(Integer id) {
        singleDepartment = null;
        departmentService.delete(id);
    }

}
