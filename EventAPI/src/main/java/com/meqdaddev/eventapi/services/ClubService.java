package com.meqdaddev.eventapi.services;

import com.meqdaddev.eventapi.dto.ClubDto;
import com.meqdaddev.eventapi.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
}
