package com.project.fms.utils.mapper;

import com.project.fms.dtos.EmployeeDTO;
import com.project.fms.dtos.UserDTO;
import com.project.fms.entity.Employee;
import com.project.fms.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjectMapper {
    List<EmployeeDTO> employeeListToDtoList(List<Employee> employees);

    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);

    List<UserDTO> userListToDtoList(List<User> users);

    User userDtoToUser(UserDTO userDTO);
}
