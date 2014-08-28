package gr.ekt.cerif.services.multilingual.qualification;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.multilingual.QualificationTitle;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface QualificationTitleCrudRepository extends CrudRepository<QualificationTitle, Long>  {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<QualificationTitle> findByQualification(Qualification qualification);

}
