package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

public interface FundingRepository {

	public void delete(Funding entity); 
	
	public void delete(Iterable<Funding> entities); 

	public Iterable<Funding> save(Iterable<Funding> entities); 
	
	public Funding save(Funding entity);
	
	Funding findByAcronym(String acronym);

	Funding findById(Long id);	
	
	List<Funding> findAll();
			   	
}
