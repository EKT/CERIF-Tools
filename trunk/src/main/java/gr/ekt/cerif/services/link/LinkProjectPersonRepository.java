/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and persons.
 * 
 */
@Component
public class LinkProjectPersonRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Transactional
	public void save(Project_Person entity) {
		if (entity.getProject() == null || entity.getPerson() == null) {
			throw new IllegalArgumentException("Please provide both a project and an person.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_Person> entityList) {
		for (Project_Person entity : entityList) {
			save(entity);
		}
	}
	
}
