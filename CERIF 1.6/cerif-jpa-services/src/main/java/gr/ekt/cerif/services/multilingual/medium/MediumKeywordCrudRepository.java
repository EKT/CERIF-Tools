package gr.ekt.cerif.services.multilingual.medium;

import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.multilingual.MediumKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MediumKeywordCrudRepository extends CrudRepository<MediumKeyword, Long> {
	
	List<MediumKeyword> findByMedium(Medium medium);

}
