package com.project.fms.services.IMPL;

import com.project.fms.dtos.UserDTO;
import com.project.fms.entity.User;
import com.project.fms.exceptions.ResultAlreadyExistException;
import com.project.fms.exceptions.ResultNotFoundException;
import com.project.fms.repository.UserRepository;
import com.project.fms.services.UserService;
import com.project.fms.utils.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAll(HashMap<String, String> params) {

        List<User> users = userRepository.findAll();
        if(!users.isEmpty()){
            List<UserDTO> usersdtos = objectMapper.userListToDtoList(users);

            if(params.isEmpty()){
                return usersdtos;
            }else{
                String username = params.get("username");
                String roleid = params.get("roleid");
                String userstatusid = params.get("userstatusid");

                Stream<UserDTO> stream = usersdtos.stream();

                if(username != null) stream = stream.filter(u -> u.getUsername().contains(username));
                if(roleid != null) stream = stream.filter(u -> u.getRole().getId().equals(Integer.parseInt(roleid)));
                if(userstatusid != null) stream = stream.filter(u -> u.getUserstatus().getId().equals(Integer.parseInt(userstatusid)));

                return stream.collect(java.util.stream.Collectors.toList());
            }
        }else{
            throw new ResultNotFoundException("Users Not Found!");
        }
    }

    @Override
    public UserDTO save(UserDTO userDTO) {

        if(userRepository.existsByUsername(userDTO.getUsername())){
            throw new ResultAlreadyExistException("Username Already Exists!");
        }

        User user = objectMapper.userDtoToUser(userDTO);
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {

        User user = userRepository.findById(userDTO.getId()).orElseThrow(()->new RuntimeException("User Not Found!"));

        if(!user.getUsername().equals(userDTO.getUsername()) && userRepository.existsByUsername(userDTO.getUsername())){
            throw new ResultAlreadyExistException("Username Already Exists!");
        }

        User user1 = objectMapper.userDtoToUser(userDTO);
        userRepository.save(user1);
        return userDTO;
    }

    @Override
    public String delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found!"));
        userRepository.delete(user);
        return "User Deleted Successfully!";
    }
}
