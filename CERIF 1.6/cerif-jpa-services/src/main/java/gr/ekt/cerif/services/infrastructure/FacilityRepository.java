package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Facility;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FacilityRepository {

	Facility findById(Long id);
	
	Facility findByAcronym(String acronym);
	
	List<Facility> findAll();
	
	void delete(Facility entity);
	
	void delete(Iterable<Facility> entities);
	
	Iterable<Facility> save(Iterable<Facility> entities);
	
	Facility save(Facility entity);
	
	Page<Facility> findAll(Pageable page);
	
	Facility findByUuid(String uuid);
	
}
