package kim.project.calendar.event;

import jakarta.servlet.http.HttpServletRequest;
import kim.project.calendar.event.domain.Event;
import kim.project.calendar.event.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @GetMapping
    public Iterable<Event> retrieveEvents() {
        log.debug("==========================================================================================");
        log.debug("# EventController.retrieveEvents");
        log.debug("==========================================================================================");

        return eventService.retrieveEvents();
    }

    @GetMapping("/{id}")
    public Event retrieveEvent(@PathVariable Long id) {
        log.debug("==========================================================================================");
        log.debug("# EventController.retrieveEvent");
        log.debug("==========================================================================================");

        return eventService.retrieveEvent(id).orElse(null);
    }

    @PostMapping
    public Event registerEvent(@RequestBody Event event) {
        log.debug("==========================================================================================");
        log.debug("# EventController.registerEvent");
        log.debug("# param:");
        log.debug("Event: {}", event.toString());
        log.debug("==========================================================================================");

        return eventService.registerEvent(event);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> registerOrUpdateEvent(@PathVariable Long id, @RequestBody Event event) {
        log.debug("==========================================================================================");
        log.debug("# EventController.registerOrUpdateEvent");
        log.debug("==========================================================================================");

        if (eventService.retrieveEvent(id).isEmpty()) {
            eventService.registerEvent(event);
            return new ResponseEntity<>(event, HttpStatus.CREATED);
        }
        eventService.updateEvent(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        log.debug("==========================================================================================");
        log.debug("# EventController.deleteEvent");
        log.debug("==========================================================================================");

        eventService.deleteEvent(id);
    }
}
