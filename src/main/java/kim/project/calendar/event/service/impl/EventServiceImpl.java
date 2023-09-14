package kim.project.calendar.event.service.impl;

import kim.project.calendar.event.domain.Event;
import kim.project.calendar.event.repository.EventRepository;
import kim.project.calendar.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public Iterable<Event> retrieveEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> retrieveEvent(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event registerEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
