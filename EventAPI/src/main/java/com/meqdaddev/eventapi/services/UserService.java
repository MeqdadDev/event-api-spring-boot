package com.meqdaddev.eventapi.services;

import com.meqdaddev.eventapi.dto.RegistrationDto;
import com.meqdaddev.eventapi.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
