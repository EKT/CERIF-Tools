package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Facility;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface FacilityCrudRepository extends CrudRepository<Facility, Long> {

	Facility findById(Long id);
	
	List<Facility> findAll();
	
	Facility findByAcronym(String acronym);
	
	Page<Facility> findAll(Pageable page);

	Facility findByUuid(String uuid);
}
