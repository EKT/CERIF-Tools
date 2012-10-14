/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.CerifBaseEntity;
import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Persistence service for CERIF Base Entities.
 * 
 */
@Component
public class BasePersistenceService {

	/**
	 * The organisation repository.
	 */
	@Autowired
	private OrganisationUnitRepository organisationRepository;
	
	/**
	 * The person repository.
	 */
	@Autowired
	private PersonRepository personRepository;
	
	/**
	 * The project repository.
	 */
	@Autowired
	private ProjectRepository projectRepository;
	
	/**
	 * Deletes the provided base entity.
	 * @param entity The base entity.
	 */
	public void delete(CerifBaseEntity entity) {
		if (entity instanceof OrganisationUnit) {
			organisationRepository.delete((OrganisationUnit)entity);
		} else if (entity instanceof Person) {
			personRepository.delete((Person)entity);
		} else if (entity instanceof Project) {
			projectRepository.delete((Project)entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid base entity provided. %s", entity));
		}
	}
	
	/**
	 * Saves the provided base entity.
	 * @param entity The base entity.
	 */
	public void save(CerifBaseEntity entity) {
		if (entity instanceof OrganisationUnit) {
			organisationRepository.save((OrganisationUnit)entity);
		} else if (entity instanceof Person) {
			personRepository.save((Person)entity);
		} else if (entity instanceof Project) {
			projectRepository.save((Project)entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid base entity provided. %s", entity));
		}
	}

	/**
	 * Saves the provided base entities.
	 * @param entity The base entities.
	 */
	@SuppressWarnings("unchecked")
	public void save(List<? extends CerifBaseEntity> entityList) {
		
		final CerifBaseEntity entity = (CerifBaseEntity)entityList.get(0);
		
		if (entity instanceof OrganisationUnit) {
			organisationRepository.save((List<OrganisationUnit>)entityList);
		} else if (entity instanceof Person) {
			personRepository.save((List<Person>)entityList);
		} else if (entity instanceof Project) {
			projectRepository.save((List<Project>)entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid list of base entities provided. %s", entity));
		}
		
	}

	/**
	 * @return the organisationRepository
	 */
	public OrganisationUnitRepository getOrganisationRepository() {
		return organisationRepository;
	}

	/**
	 * @param organisationRepository the organisationRepository to set
	 */
	public void setOrganisationRepository(
			OrganisationUnitRepository organisationRepository) {
		this.organisationRepository = organisationRepository;
	}

	/**
	 * @return the personRepository
	 */
	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	/**
	 * @param personRepository the personRepository to set
	 */
	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	/**
	 * @return the projectRepository
	 */
	public ProjectRepository getProjectRepository() {
		return projectRepository;
	}

	/**
	 * @param projectRepository the projectRepository to set
	 */
	public void setProjectRepository(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
}
