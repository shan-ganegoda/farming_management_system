package com.project.fms.services.IMPL;

import com.project.fms.dtos.PrivilegeDTO;
import com.project.fms.entity.Privilege;
import com.project.fms.exceptions.ResultAlreadyExistException;
import com.project.fms.exceptions.ResultNotFoundException;
import com.project.fms.repository.PrivilegeRepository;
import com.project.fms.services.PrivilegeService;
import com.project.fms.utils.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PrivilegeServiceIMPL implements PrivilegeService {

    private final PrivilegeRepository privilegeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<PrivilegeDTO> getAll(HashMap<String, String> params) {

        List<Privilege> privileges = privilegeRepository.findAll();
        if(!privileges.isEmpty()){
            List<PrivilegeDTO> list = objectMapper.privilegeListToDtoList(privileges);
            if(params.isEmpty()){
                return list;
            }else{
                String roleid = params.get("roleid");
                String moduleid = params.get("moduleid");
                String operationid = params.get("operationid");

                Stream<PrivilegeDTO> stream = list.stream();

                if(roleid != null) stream = stream.filter(p -> p.getRole().getId().equals(Integer.parseInt(roleid)));
                if(moduleid != null) stream = stream.filter(p -> p.getModule().getId().equals(Integer.parseInt(moduleid)));
                if(operationid != null) stream = stream.filter(p -> p.getOperation().getId().equals(Integer.parseInt(operationid)));

                return stream.collect(java.util.stream.Collectors.toList());
            }
        }else{
            throw new ResultNotFoundException("Privileges Not Found!");
        }
    }

    @Override
    public PrivilegeDTO save(PrivilegeDTO privilegeDTO) {

        if(privilegeRepository.existsByRoleAndModuleAndOperation(privilegeDTO.getRole(), privilegeDTO.getModule(), privilegeDTO.getOperation())){
            throw new ResultAlreadyExistException("Privilege Already Exists!");
        }

        Privilege privilege = objectMapper.privilegeDtoToPrivilege(privilegeDTO);
        privilegeRepository.save(privilege);
        return privilegeDTO;
    }

    @Override
    public PrivilegeDTO update(PrivilegeDTO privilegeDTO) {
        return this.save(privilegeDTO);
    }

    @Override
    public String delete(Integer id) {
        Privilege privilege = privilegeRepository.findById(id).orElseThrow(()->new ResultNotFoundException("Privilege Not Found!"));
        privilegeRepository.delete(privilege);
        return "Privilege Deleted Successfully";
    }
}
