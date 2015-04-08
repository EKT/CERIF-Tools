package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_CurriculumVitae;
import gr.ekt.cerif.entities.second.CurriculumVitae;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between persons and cvs.
 * 
 */
public interface LinkPersonCurriculumVitaeRepository {

	Person_CurriculumVitae save(Person_CurriculumVitae entity);
	
	Person_CurriculumVitae findPersonCVByPersonIdAndClassId(Long personId, Long theClassId);
	
	Person_CurriculumVitae findPersonCVByPersonIdAndClassUri(Long personId, String theClassUri);
	
	Iterable<Person_CurriculumVitae> save(Iterable<Person_CurriculumVitae> entityList);
	
	void delete(Person_CurriculumVitae entity);
	
	void delete(Iterable<Person_CurriculumVitae> entityList);
	
	List<Person_CurriculumVitae> findByPerson(Person person);
	
	List<Person_CurriculumVitae> findByCurriculumVitae(CurriculumVitae curriculumVitae);
	
	List<Person_CurriculumVitae> findByPersonAndTheClass(Person person, Class theClass);
	
}
