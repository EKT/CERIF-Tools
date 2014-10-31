package gr.ekt.cerif.services.additional;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.features.additional.PersonName;

public interface PersonNameRepository {
	
	void delete(PersonName entity); 
	
	void delete(Iterable<PersonName> entities); 

	Iterable<PersonName> save(Iterable<PersonName> entities); 
	
	PersonName save(PersonName entity);
	
	List<PersonName> findAll();
	
	Page<PersonName> findAll(Pageable page);
	
	PersonName findById(Long id);
	
	List<PersonName> findAllNamesByPersonId(Long id);

}
