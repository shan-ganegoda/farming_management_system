package com.project.fms.services;

import com.project.fms.dtos.PrivilegeDTO;

import java.util.HashMap;
import java.util.List;

public interface PrivilegeService{
    List<PrivilegeDTO> getAll(HashMap<String, String> params);

    PrivilegeDTO save(PrivilegeDTO privilegeDTO);

    PrivilegeDTO update(PrivilegeDTO privilegeDTO);

    String delete(Integer id);
}
