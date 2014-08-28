package gr.ekt.cerif.services.multilingual.prize;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.multilingual.PrizeKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface PrizeKeywordCrudRepository extends CrudRepository<PrizeKeyword, Long>  {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<PrizeKeyword> findByPrize(Prize prize);

}
