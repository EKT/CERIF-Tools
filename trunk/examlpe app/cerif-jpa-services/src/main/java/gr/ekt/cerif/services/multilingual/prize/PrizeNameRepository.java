package gr.ekt.cerif.services.multilingual.prize;

import gr.ekt.cerif.features.multilingual.PrizeName;

public interface PrizeNameRepository {

	public void delete(PrizeName entity); 
	
	public void delete(Iterable<PrizeName> entities); 

	public Iterable<PrizeName> save(Iterable<PrizeName> entities); 
	
	public PrizeName save(PrizeName entity);
}
