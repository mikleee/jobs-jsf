package com.aimprosoft.jobs.service;

import com.aimprosoft.jobs.model.Department;

import java.util.List;

/**
 * Created on 12/23/13.
 */
public interface DepartmentService {

    List<Department> findAll();

    Department findOne(Integer id);
}
