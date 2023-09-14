package kim.project.calendar.event.service;

import kim.project.calendar.event.domain.Event;

import java.util.Optional;

public interface EventService {
    public Iterable<Event> retrieveEvents();
    public Optional<Event> retrieveEvent(Long id);
    public Event registerEvent(Event event);
    public void updateEvent(Event event);
    public void deleteEvent(Long id);
}
