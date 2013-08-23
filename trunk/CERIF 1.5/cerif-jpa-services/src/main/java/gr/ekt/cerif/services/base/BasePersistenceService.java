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
import org.springframework.transaction.annotation.Transactional;

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
	private OrganisationUnitRepository organisationUnitRepository;
	
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
	@Transactional
	public void delete(CerifBaseEntity entity) {
		if (entity instanceof OrganisationUnit) {
			organisationUnitRepository.delete((OrganisationUnit)entity);
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
	@Transactional
	public CerifBaseEntity save(CerifBaseEntity entity) {
		if (entity instanceof OrganisationUnit) {
			entity = organisationUnitRepository.save((OrganisationUnit) entity);
		} else if (entity instanceof Person) {
			entity = personRepository.save((Person) entity);
		} else if (entity instanceof Project) {
			entity = projectRepository.save((Project) entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid base entity provided. %s", entity));
		}
		return entity;
	}

	/**
	 * Saves the provided base entities.
	 * @param entity The base entities.
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Iterable<? extends CerifBaseEntity> save(Iterable<? extends CerifBaseEntity> entityList) {
		
		final CerifBaseEntity entity = (CerifBaseEntity)entityList.iterator().next();
		
		if (entity instanceof OrganisationUnit) {
			entityList = organisationUnitRepository.save((List<OrganisationUnit>) entityList);
		} else if (entity instanceof Person) {
			entityList = personRepository.save((List<Person>) entityList);
		} else if (entity instanceof Project) {
			entityList = projectRepository.save((List<Project>) entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid list of base entities provided. %s", entity));
		}
		return entityList;
	}
	
	/**
	 * Deletes the provided base entities.
	 * @param entity The base entities.
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public void delete(Iterable<? extends CerifBaseEntity> entityList) {
		
		final CerifBaseEntity entity = (CerifBaseEntity)entityList.iterator().next();
		
		if (entity instanceof OrganisationUnit) {
			organisationUnitRepository.delete((List<OrganisationUnit>) entityList);
		} else if (entity instanceof Person) {
			personRepository.delete((List<Person>) entityList);
		} else if (entity instanceof Project) {
			projectRepository.delete((List<Project>) entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid list of base entities provided. %s", entity));
		}
	}

	/**
	 * @return the organisationUnitRepository
	 */
	public OrganisationUnitRepository getOrganisationUnitRepository() {
		return organisationUnitRepository;
	}

	/**
	 * @return the personRepository
	 */
	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	/**
	 * @return the projectRepository
	 */
	public ProjectRepository getProjectRepository() {
		return projectRepository;
	}
	
	
}
