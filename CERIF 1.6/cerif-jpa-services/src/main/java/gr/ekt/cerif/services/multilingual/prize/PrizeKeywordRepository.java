package gr.ekt.cerif.services.multilingual.prize;

import java.util.List;

import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.multilingual.PrizeKeyword;

public interface PrizeKeywordRepository {
	
	public void delete(PrizeKeyword entity); 
	
	public void delete(Iterable<PrizeKeyword> entities); 

	public Iterable<PrizeKeyword> save(Iterable<PrizeKeyword> entities); 
	
	public PrizeKeyword save(PrizeKeyword entity);
	
	List<PrizeKeyword> findByPrize(Prize prize);

}
