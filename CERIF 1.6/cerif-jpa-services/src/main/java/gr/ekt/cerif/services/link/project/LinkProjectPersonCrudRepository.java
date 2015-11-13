package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectPersonCrudRepository extends CrudRepository<Project_Person, Long> {
	
	Project_Person findByProjectAndPerson(Project project, Person person);

	List <Project_Person> findByPerson(Person person);
	
	List <Project_Person> findByTheClass(Class theClass);
	
	List <Project_Person> findByProject(Project project);

}
