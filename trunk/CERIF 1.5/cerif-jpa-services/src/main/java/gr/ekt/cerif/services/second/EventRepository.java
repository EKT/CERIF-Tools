package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.Event;

public interface EventRepository {
	
	Event findById(Long id);
	
	void delete(Event entity); 
	
	void delete(Iterable<Event> entities); 

	Iterable<Event> save(Iterable<Event> entities); 
	
	Event save(Event entity);
	
	List<Event> findAll();
	
	Page<Event> findAll(Pageable page);

	List<Event> findByUri(String uri);

	Event findByUuid(String uuid);
	
}
