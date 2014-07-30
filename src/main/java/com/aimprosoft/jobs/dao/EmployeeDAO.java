package com.aimprosoft.jobs.dao;

import com.aimprosoft.jobs.model.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created on 12/23/13.
 */
public interface EmployeeDAO extends CrudRepository<Employee, Integer> {


}
