package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Facility;

import org.springframework.data.repository.CrudRepository;

public interface FacilityRepository extends CrudRepository<Facility, String>{
	Facility findById(Long id);
	Facility findByAcronym(String acronym);
}
