package gr.ekt.cerif.services.multilingual.prize;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.multilingual.PrizeDescription;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface PrizeDescriptionCrudRepository extends CrudRepository<PrizeDescription, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<PrizeDescription> findByPrize(Prize prize);

}
