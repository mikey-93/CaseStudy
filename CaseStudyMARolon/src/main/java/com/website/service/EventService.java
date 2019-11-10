package com.website.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.model.Event;
import com.website.repository.EventRepository;

//@Transactional
@Service
public class EventService {
   
   @Autowired
   EventRepository eventRepository;
   
   public Event getEventByName(String name) {
      return eventRepository.findByName(name);
   }
   
   public Event getEventByCity(String city) {
      return eventRepository.findByCity(city);
   }
   
   public Event getEventByState(String state) {
      return eventRepository.findByState(state);
   }
   
   public List<Event> getAllEvents() {
      List<Event> events = new ArrayList<>();
      eventRepository.findAll().forEach(
            (e) -> {events.add(e);
            });
      return events;
   }
}