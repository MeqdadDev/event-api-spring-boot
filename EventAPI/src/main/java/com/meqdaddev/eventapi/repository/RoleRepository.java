package com.meqdaddev.eventapi.repository;

import com.meqdaddev.eventapi.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
