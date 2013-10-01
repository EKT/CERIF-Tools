package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Facility;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface FacilityCrudRepository extends CrudRepository<Facility, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Facility findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Facility findByAcronym(String acronym);
}
