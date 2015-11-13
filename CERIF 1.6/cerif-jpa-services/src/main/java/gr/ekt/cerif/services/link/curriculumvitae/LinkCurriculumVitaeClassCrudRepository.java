package gr.ekt.cerif.services.link.curriculumvitae;

import gr.ekt.cerif.entities.link.CurriculumVitae_Class;
import gr.ekt.cerif.entities.second.CurriculumVitae;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkCurriculumVitaeClassCrudRepository extends CrudRepository<CurriculumVitae_Class, Long> {
	
	List<CurriculumVitae_Class> findByCurriculumVitae(CurriculumVitae curriculumVitae);
	
	List<CurriculumVitae_Class> findBytheClass(Class theClass);

}
