package gr.ekt.cerif.services.multilingual.qualification;

import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.multilingual.QualificationDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QualificationDescriptionCrudRepository  extends CrudRepository<QualificationDescription, Long> {
	
	List<QualificationDescription> findByQualification(Qualification qualification);

}
