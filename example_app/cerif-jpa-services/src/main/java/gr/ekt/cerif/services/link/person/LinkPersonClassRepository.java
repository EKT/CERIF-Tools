package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

/**
 * A repository for links between persons and classes.
 * 
 */

public interface LinkPersonClassRepository {

	Person_Class findById(Long id);
	
	Person_Class findByPersonClassSchemeAndClass(Person person, Class theClass, ClassScheme scheme);
	
	List<Person_Class> findByPersonClassScheme(Person person, ClassScheme scheme);
	
	List <Person_Class> findByPerson(Person person);
	
	Person_Class findByPersonAndTheClass(Person person, Class theClass);
	
	Person_Class findByPersonIdAndClassId(Long personId, Long classId);
	
	Person_Class findByPersonIdAndClassUri(Long personId, String classUri);
	
	List<Person_Class> findByPersonIdClassSchemeUri(Long personId, String schemeUri);
	
	Person_Class findPersClassByPersonIdAndSchemeId(Long personId, Long schemeId);

	Person_Class findPersClassByPersonIdAndSchemeUri(Long personId, String schemeUri);
	
	Person_Class findPersonUserState(Long personId);
	
	public Person_Class save(Person_Class entity);
	
	public Iterable<Person_Class> save(Iterable<Person_Class> entityList);
	
	public void delete(Person_Class entity);
	
	public void delete(Iterable<Person_Class> entityList);
	
	public Person_Class updatePerson_Class(Person_Class personClassToSave, boolean replaceAll, Class classToReplace);
	
	public void updatePerson_ClassList(Person person, List<Long> classIds, String classSchemeUri);

}
