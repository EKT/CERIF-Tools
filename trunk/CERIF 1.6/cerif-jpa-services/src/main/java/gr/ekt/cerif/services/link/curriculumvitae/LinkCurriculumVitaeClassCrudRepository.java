package gr.ekt.cerif.services.link.curriculumvitae;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.CurriculumVitae_Class;
import gr.ekt.cerif.entities.second.CurriculumVitae;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkCurriculumVitaeClassCrudRepository extends CrudRepository<CurriculumVitae_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<CurriculumVitae_Class> findByCurriculumVitae(CurriculumVitae curriculumVitae);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<CurriculumVitae_Class> findBytheClass(Class theClass);

}
