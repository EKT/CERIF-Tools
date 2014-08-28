package gr.ekt.cerif.services.multilingual.prize;

import java.util.List;

import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.multilingual.PrizeDescription;

public interface PrizeDescriptionRepository {
	
	public void delete(PrizeDescription entity); 
	
	public void delete(Iterable<PrizeDescription> entities); 

	public Iterable<PrizeDescription> save(Iterable<PrizeDescription> entities); 
	
	public PrizeDescription save(PrizeDescription entity);
	
	List<PrizeDescription> findByPrize(Prize prize);

}
