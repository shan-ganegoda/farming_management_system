package com.project.fms.services;

import com.project.fms.dtos.EmployeeDTO;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAll(HashMap<String, String> params);

    EmployeeDTO create(EmployeeDTO employeeDTO);

    EmployeeDTO update(EmployeeDTO employeeDTO);

    String delete(Integer id);
}
