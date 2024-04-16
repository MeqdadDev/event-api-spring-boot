package com.meqdaddev.eventapi.services;

import com.meqdaddev.eventapi.dto.EventDto;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);

}
