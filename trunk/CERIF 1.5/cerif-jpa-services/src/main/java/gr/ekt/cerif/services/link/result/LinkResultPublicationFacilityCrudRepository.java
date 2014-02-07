package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;
import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationFacilityCrudRepository extends CrudRepository<ResultPublication_Facility, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublication_Facility> findByResultPublication(ResultPublication resultPublication);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublication_Facility> findByFacility(Facility facility);

}
