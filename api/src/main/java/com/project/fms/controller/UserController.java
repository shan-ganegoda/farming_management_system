package com.project.fms.controller;

import com.project.fms.dtos.UserDTO;
import com.project.fms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAll(@RequestParam HashMap<String, String> params){
        return userService.getAll(params);
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO){
        return userService.update(userDTO);
    }

    @DeleteMapping("{/id}")
    public String delete(@PathVariable Integer id){
        return userService.delete(id);
    }

}
