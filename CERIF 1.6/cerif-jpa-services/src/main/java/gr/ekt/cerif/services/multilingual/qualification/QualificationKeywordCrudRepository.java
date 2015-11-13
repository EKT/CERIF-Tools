package gr.ekt.cerif.services.multilingual.qualification;

import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.multilingual.QualificationKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QualificationKeywordCrudRepository  extends CrudRepository<QualificationKeyword, Long> {
	
	List<QualificationKeyword> findByQualification(Qualification qualification);

}
