package com.meqdaddev.eventapi.services.implementations;

import com.meqdaddev.eventapi.dto.EventDto;
import com.meqdaddev.eventapi.models.Club;
import com.meqdaddev.eventapi.models.Event;
import com.meqdaddev.eventapi.repository.ClubRepository;
import com.meqdaddev.eventapi.repository.EventRepository;
import com.meqdaddev.eventapi.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.meqdaddev.eventapi.mapper.EventMapper.mapToEvent;
import static com.meqdaddev.eventapi.mapper.EventMapper.mapToEventDto;

@Service
public class EventImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ClubRepository clubRepository;

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

}
