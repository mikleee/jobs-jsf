package com.aimprosoft.jobs.service.impl;

import com.aimprosoft.jobs.dao.DepartmentDAO;
import com.aimprosoft.jobs.model.Department;
import com.aimprosoft.jobs.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created on 17.12.13.
 */
@Component
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;


    @Override
    public List<Department> findAll() {
        List<Department> result = (List<Department>) departmentDAO.findAll();
        Collections.sort(result);
        return result;
    }


    @Override
    public Department findOne(Integer id) {
        return departmentDAO.findOne(id);
    }


    @Override
    public Department save(Department department) {
        return departmentDAO.save(department);
    }


    @Override
    public void delete(Integer id) {
        departmentDAO.delete(id);
    }


}
