package com.project.fms.services.IMPL;


import com.project.fms.dtos.EmployeeDTO;
import com.project.fms.entity.Employee;
import com.project.fms.exceptions.ResultAlreadyExistException;
import com.project.fms.exceptions.ResultNotFoundException;
import com.project.fms.repository.EmployeeRepository;
import com.project.fms.services.EmployeeService;
import com.project.fms.utils.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {
    
    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<EmployeeDTO> getAll(HashMap<String, String> params) {

        List<Employee> employees = employeeRepository.findAll();

        if(!employees.isEmpty()) {
            List<EmployeeDTO> emplist = objectMapper.employeeListToDtoList(employees);

            if(params.isEmpty()){
                return emplist;
            }else{

                String lastname = params.get("lastname");
                String nic = params.get("nic");
                String designationid = params.get("designationid");
                String employeestatusid = params.get("employeestatusid");
                String genderid = params.get("genderid");

                Stream<EmployeeDTO> stream = emplist.stream();

                if(lastname != null) stream = stream.filter(e -> e.getLastname().contains(lastname));
                if(nic != null) stream = stream.filter(e -> e.getNic().equals(nic));
                if(designationid != null) stream = stream.filter(e -> e.getDesignation().getId().equals(Integer.parseInt(designationid)));
                if(employeestatusid != null) stream = stream.filter(e -> e.getEmployeestatus().getId().equals(Integer.parseInt(employeestatusid)));
                if(genderid != null) stream = stream.filter(e -> e.getGender().getId().equals(Integer.parseInt(genderid)));

                return stream.collect(Collectors.toList());

            }
        }else{
            throw new ResultNotFoundException("No Employee Found");
        }

    }

    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {

        if(employeeRepository.existsByNic(employeeDTO.getNic())){
            throw new ResultAlreadyExistException("NIC Already Exists!");
        }
        if(employeeRepository.existsByEmail(employeeDTO.getEmail())){
            throw new ResultAlreadyExistException("Email Already Exists!");
        }
        if(employeeRepository.existsByMobile(employeeDTO.getMobile())){
            throw new ResultAlreadyExistException("Mobile Already Exists!");
        }
        if(employeeRepository.existsByLand(employeeDTO.getLand())){
            throw new ResultAlreadyExistException("Land Already Exists!");
        }
        if(employeeRepository.existsByEmpnumber(employeeDTO.getEmpnumber())){
            throw new ResultAlreadyExistException("Employee Number Already Exists!");
        }

        Employee emp = objectMapper.employeeDtoToEmployee(employeeDTO);

        employeeRepository.save(emp);
        return employeeDTO;


    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {

        Employee employee = employeeRepository.findById(employeeDTO.getId()).orElseThrow(()->new ResultNotFoundException("Employee Not Found!"));

        if(!employee.getEmail().equals(employeeDTO.getEmail()) && employeeRepository.existsByEmail(employeeDTO.getEmail())){
            throw new ResultAlreadyExistException("Email Already Exist!");
        }
        if(!employee.getEmpnumber().equals(employeeDTO.getEmpnumber()) && employeeRepository.existsByEmpnumber(employeeDTO.getEmpnumber())){
            throw new ResultAlreadyExistException("Number No Already Exist!");
        }
        if(!employee.getNic().equals(employeeDTO.getNic()) && employeeRepository.existsByNic(employeeDTO.getNic())){
            throw new ResultAlreadyExistException("Nic Already Exist!");
        }
        if(!employee.getMobile().equals(employeeDTO.getMobile()) && employeeRepository.existsByMobile(employeeDTO.getMobile())){
            throw new ResultAlreadyExistException("Mobile Already Exist!");
        }
        if(!employee.getLand().equals(employeeDTO.getLand()) && employeeRepository.existsByLand(employeeDTO.getLand())){
            throw new ResultAlreadyExistException("Land Already Exist!");
        }

        Employee employee1 = objectMapper.employeeDtoToEmployee(employeeDTO);
        employeeRepository.save(employee1);
        return employeeDTO;

    }

    @Override
    public String delete(Integer id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResultNotFoundException("Employee Not Found!"));
        employeeRepository.delete(employee);
        return "Employee Successfully Deleted";
    }
}
