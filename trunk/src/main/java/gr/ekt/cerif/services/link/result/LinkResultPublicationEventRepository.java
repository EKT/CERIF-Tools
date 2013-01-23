package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.result.ResultPublication;

/**
 * A repository for links between resultPublications and events.
 * 
 */
public interface LinkResultPublicationEventRepository {
	
	ResultPublication_Event save(ResultPublication_Event entity);
	
	Iterable<ResultPublication_Event> save(Iterable<ResultPublication_Event> entityList);
	
	void delete(ResultPublication_Event entity);
	
	void delete(Iterable<ResultPublication_Event> entityList);
	
	ResultPublication_Event queryResPubEventById(Long respubevId);
	
	List<ResultPublication_Event> findByResultPublication(ResultPublication resultPublication);
	
}
