package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Event;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationEventCrudRepository extends CrudRepository<ResultPublication_Event, Long> {
	
	List<ResultPublication_Event> findByResultPublication(ResultPublication resultPublication);
	
	List<ResultPublication_Event> findByEvent(Event event);
	
	@Query(value = "select respubev" +
			   "  from ResultPublication respub  "+
			   "  left join respub.resultPublications_events respubev "+
			   "  where respub.id=?1")
	List<ResultPublication_Event> findResPublEventByResPublId(Long id);
	
	@Query(value = " select respubev from ResultPublication respub "+
			"  left join respub.resultPublications_events respubev " +
			"  left join respubev.theClass respubevcl " +
			"  where respub.id = ?1 and respubevcl.uri= ?2   ")
	List<ResultPublication_Event> findByResPublIdAndClassUri(Long respubId, String classUri);
	
	@Query(value = " select respubev from ResultPublication respub "+
			"  left join respub.resultPublications_events respubev " +
			"  left join respubev.event ev " +
			"  left join respubev.theClass respubevcl " +
			"  where respub.id = ?1 and respubevcl.uri= ?2 "+
			"  and ev.id= ?3   ")
	ResultPublication_Event findByResPublIdAndClassUriAndEventId(Long respubId, String classUri, Long eventId);

}
