package gr.ekt.cerif.services.multilingual.qualification;

import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.multilingual.QualificationTitle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QualificationTitleCrudRepository extends CrudRepository<QualificationTitle, Long>  {
	
	List<QualificationTitle> findByQualification(Qualification qualification);

}
