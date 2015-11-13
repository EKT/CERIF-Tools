package gr.ekt.cerif.services.multilingual.prize;

import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.multilingual.PrizeKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PrizeKeywordCrudRepository extends CrudRepository<PrizeKeyword, Long>  {
	
	List<PrizeKeyword> findByPrize(Prize prize);

}
