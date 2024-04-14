package com.meqdaddev.eventapi.repository;

import com.meqdaddev.eventapi.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
