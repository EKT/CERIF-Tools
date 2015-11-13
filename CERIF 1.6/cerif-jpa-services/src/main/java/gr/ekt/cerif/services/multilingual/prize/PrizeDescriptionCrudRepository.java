package gr.ekt.cerif.services.multilingual.prize;

import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.multilingual.PrizeDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PrizeDescriptionCrudRepository extends CrudRepository<PrizeDescription, Long> {
	
	List<PrizeDescription> findByPrize(Prize prize);

}
