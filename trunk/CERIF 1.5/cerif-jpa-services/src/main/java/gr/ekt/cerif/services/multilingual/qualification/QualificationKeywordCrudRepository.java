package gr.ekt.cerif.services.multilingual.qualification;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.multilingual.QualificationKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface QualificationKeywordCrudRepository  extends CrudRepository<QualificationKeyword, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<QualificationKeyword> findByQualification(Qualification qualification);

}
