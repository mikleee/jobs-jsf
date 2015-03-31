package com.aimprosoft.jobs.controller;

import com.aimprosoft.jobs.model.Department;
import com.aimprosoft.jobs.utils.RandomObjectCreator;

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
public class DepartmentList extends BaseManagedBean {

    private List<SelectItem> departmentList;

    {
        departmentList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Department department = RandomObjectCreator.createRandomObject(new Department(), i);
            SelectItem selectItem = new SelectItem(department.getId(), department.getName());
            departmentList.add(selectItem);
        }
    }


    public List<SelectItem> getDepartmentList() {
//        for (Department department : departmentService.findAll()) {
//            SelectItem selectItem = new SelectItem(department.getId(), department.getName());
//            departmentList.add(selectItem);
//        }
        return departmentList;
    }


    public void setDepartmentList(List<SelectItem> departmentList) {
        this.departmentList = departmentList;
    }

}
