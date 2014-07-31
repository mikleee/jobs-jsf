package com.aimprosoft.jobs.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.util.List;

/**
 * @author Mikhail Tkachenko
 */
@ManagedBean
@SessionScoped
public class DepartmentList extends BaseManagedBean {

    private List<SelectItem> departmentList;


    public List<SelectItem> getDepartmentList() {
        return departmentService.findAll();
    }


    public void setDepartmentList(List<SelectItem> departmentList) {
        this.departmentList = departmentList;
    }

}
