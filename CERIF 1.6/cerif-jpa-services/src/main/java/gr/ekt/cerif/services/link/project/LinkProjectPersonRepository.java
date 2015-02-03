/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;


/**
 * A repository for links between projects and persons.
 * 
 */

public interface LinkProjectPersonRepository {
	
	public Project_Person findByProjectAndPerson(Project project, Person person);

	List <Project_Person> findByPerson(Person person);
	
	List <Project_Person> findByTheClass(Class theClass);
	
	List <Project_Person> findByProject(Project project);
	
	public void delete(Project_Person entity); 
	
	public void delete(Iterable<Project_Person> entities); 

	public Iterable<Project_Person> save(Iterable<Project_Person> entities); 
	
	public Project_Person save(Project_Person entity);
	
}
