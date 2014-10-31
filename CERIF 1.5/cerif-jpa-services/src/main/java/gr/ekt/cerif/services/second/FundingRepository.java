package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FundingRepository {

	void delete(Funding entity); 
	
	void delete(Iterable<Funding> entities); 

	Iterable<Funding> save(Iterable<Funding> entities); 
	
	Funding save(Funding entity);
	
	Funding findByAcronym(String acronym);

	Funding findById(Long id);	
	
	List<Funding> findAll();
	
	Page<Funding> findAll(Pageable page);
	
	Funding findByUri(String Uri);
	
	Funding findByUUID(String uuid);
			   	
}
