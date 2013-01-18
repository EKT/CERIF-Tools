/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.EventView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for events.
 * 
 */
public interface EventRepository extends CrudRepository<Event, String> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.second.EventView(" +
			   "       ev.id,  "+
			   "       evnames.name,   "+
			   "       ev.startDate,   "+
			   "       ev.endDate,   "+
			   "       cl.uri,   "+
			   "       ev.cityTown,   "+
			   "       cou.uri,   "+
			   "       orgunitname.name,   "+
			   "       ev.uri,   "+
			   "       proj.acronym)      	" +
			   "  from Event ev    		" +
			   "  left join ev.names evnames  	" +
			   "  left join ev.country cou  	" +
			   "  left join ev.classes evclasses  		" +
			   "  left join evclasses.theClass cl  		" +
			   "  left join ev.organisationUnit_events orgunitev  	" +
			   "  left join orgunitev.organisationUnit orgunit  	" +
			   "  left join orgunit.organisationUnitNames orgunitname  	" +
			   "  left join ev.projects_events projev  	" +
			   "  left join projev.project proj  	")
	List<EventView> findAllEvents();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.second.EventView(" +
			   "       ev.id,  "+
			   "       evnames.name,   "+
			   "       ev.startDate,   "+
			   "       ev.endDate,   "+
			   "       cl.uri,   "+
			   "       ev.cityTown,   "+
			   "       cou.uri,   "+
			   "       orgunitname.name,   "+
			   "       ev.uri,   "+
			   "       proj.acronym)      	" +
			   "  from Event ev    		" +
			   "  left join ev.names evnames  	" +
			   "  left join ev.country cou  	" +
			   "  left join ev.classes evclasses  		" +
			   "  left join evclasses.theClass cl  		" +
			   "  left join ev.organisationUnit_events orgunitev  	" +
			   "  left join orgunitev.organisationUnit orgunit  	" +
			   "  left join orgunit.organisationUnitNames orgunitname  	" +
			   "  left join ev.projects_events projev  	" +
			   "  left join projev.project proj  where ev.id = ?1	")
	EventView findEventById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.second.EventView(" +
			   "       ev.id,  "+
			   "       evnames.name)   "+
			   "  from Event ev    		" +
			   "  left join ev.names evnames  	")
	List<EventView> findAllEventsNameIdOnly();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ev from Event ev where ev.id = ?1" )
	Event findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ev" +
			   "  from ResultPublication respub  "+
			   "  left join respub.resultPublications_events respubev "+
			   "  left join respubev.event ev "+
			   "  where respub.id=?1")
	Event findByResPublId(Long id);
	
}
