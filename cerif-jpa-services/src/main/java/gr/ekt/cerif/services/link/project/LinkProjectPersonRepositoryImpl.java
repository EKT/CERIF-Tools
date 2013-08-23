package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.base.ProjectRepositoryImpl;
import gr.ekt.cerif.services.multilingual.theclass.ClassTermCrudRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkProjectPersonRepositoryImpl implements
		LinkProjectPersonRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectPersonRepositoryImpl.class);
	
	@Autowired
	private LinkProjectPersonCrudRepository linkProjectPersonCrudRepository;

	@Override
	public Project_Person findByProjectAndPerson(Project project, Person person) {
		return linkProjectPersonCrudRepository.findByProjectAndPerson(project, person);
	}

	@Override
	public List<Project_Person> findByPerson(Person person) {
		return linkProjectPersonCrudRepository.findByPerson(person);
	}

	@Override
	public List<Project_Person> findByTheClass(Class theClass) {
		return linkProjectPersonCrudRepository.findByTheClass(theClass);
	}

	@Override
	public List<Project_Person> findByProject(Project project) {
		return linkProjectPersonCrudRepository.findByProject(project);
	}

	@Override
	public void delete(Project_Person entity) {
		linkProjectPersonCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Project_Person> entities) {
		linkProjectPersonCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Project_Person> save(Iterable<Project_Person> entities) {
		return linkProjectPersonCrudRepository.save(entities);
	}

	@Override
	public Project_Person save(Project_Person entity) {
		return linkProjectPersonCrudRepository.save(entity);
	}

}
