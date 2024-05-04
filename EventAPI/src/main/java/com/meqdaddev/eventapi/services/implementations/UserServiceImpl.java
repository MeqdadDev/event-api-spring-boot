package com.meqdaddev.eventapi.services.implementations;

import com.meqdaddev.eventapi.dto.RegistrationDto;
import com.meqdaddev.eventapi.models.Role;
import com.meqdaddev.eventapi.models.UserEntity;
import com.meqdaddev.eventapi.repository.RoleRepository;
import com.meqdaddev.eventapi.repository.UserRepository;
import com.meqdaddev.eventapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
