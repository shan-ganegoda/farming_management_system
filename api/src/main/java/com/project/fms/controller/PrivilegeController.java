package com.project.fms.controller;

import com.project.fms.dtos.PrivilegeDTO;
import com.project.fms.services.PrivilegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/privilege")
@RequiredArgsConstructor
public class PrivilegeController {

    private final PrivilegeService privilegeService;

    @GetMapping
    public List<PrivilegeDTO> getAll(@RequestParam HashMap<String, String> params){
        return privilegeService.getAll(params);
    }

    @PostMapping
    public PrivilegeDTO save(@RequestBody PrivilegeDTO privilegeDTO){
        return privilegeService.save(privilegeDTO);
    }

    @PutMapping
    public PrivilegeDTO update(@RequestBody PrivilegeDTO privilegeDTO){
        return privilegeService.update(privilegeDTO);
    }

    @DeleteMapping("{/id}")
    public String delete(@PathVariable Integer id){
        return privilegeService.delete(id);
    }
}
