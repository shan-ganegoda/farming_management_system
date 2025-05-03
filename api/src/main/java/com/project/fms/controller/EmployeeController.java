package com.project.fms.controller;

import com.project.fms.dtos.EmployeeDTO;
import com.project.fms.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAll(@RequestParam HashMap<String, String> params) {
        return employeeService.getAll(params);
    }

    @PostMapping
    public EmployeeDTO create(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.create(employeeDTO);
    }

    @PutMapping
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.update(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return employeeService.delete(id);
    }

}
