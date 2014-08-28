package gr.ekt.cerif.services.multilingual.qualification;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.multilingual.QualificationDescription;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface QualificationDescriptionCrudRepository  extends CrudRepository<QualificationDescription, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<QualificationDescription> findByQualification(Qualification qualification);

}
