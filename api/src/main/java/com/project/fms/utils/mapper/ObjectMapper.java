package com.project.fms.utils.mapper;

import com.project.fms.dtos.EmployeeDTO;
import com.project.fms.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjectMapper {
    List<EmployeeDTO> employeeListToDtoList(List<Employee> employees);

    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);
}
