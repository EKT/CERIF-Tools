package gr.ekt.cerif.services.multilingual.medium;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.multilingual.MediumKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface MediumKeywordCrudRepository extends CrudRepository<MediumKeyword, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<MediumKeyword> findByMedium(Medium medium);

}
