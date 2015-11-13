package gr.ekt.cerif.services.multilingual.prize;

import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.multilingual.PrizeName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PrizeNameCrudRepository  extends CrudRepository<PrizeName, Long> {
	
	List<PrizeName> findByPrize(Prize prize);

}
