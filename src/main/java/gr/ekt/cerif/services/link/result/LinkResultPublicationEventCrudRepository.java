package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationEventCrudRepository extends CrudRepository<ResultPublication_Event, Long> {
	
	List<ResultPublication_Event> findByResultPublication(ResultPublication resultPublication);

}
