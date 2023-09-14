package kim.project.calendar.event.repository;

import kim.project.calendar.event.domain.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
