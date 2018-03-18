package ua.epam.spring.hometask.dao.impl;

import ua.epam.spring.hometask.dao.EventDao;
import ua.epam.spring.hometask.domain.Event;

import javax.annotation.PostConstruct;
import java.util.*;

public class EventDaoImpl implements EventDao{
    private Map<Long, Event> events;

    @PostConstruct
    private void init(){
        events = new HashMap<>();
    }

    @Override
    public Event findById(long id) {
        return null;
    }

    @Override
    public Collection<Event> findAll() {
        return events.values();
    }

    @Override
    public Event save(Event event) {
        if (event.getId() == null) {
            Optional<Long> lastId = events.keySet().stream().max(Comparator.naturalOrder());
            Long newId = lastId.orElse(0L) + 1L;
            event.setId(newId);
        }
        events.put(event.getId(), event);
        return event;
    }
}
