/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and organisations.
 * 
 */
@Component
public class LinkProjectOrganisationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private OrganisationUnitRepository organisationRepository;
	
	@Transactional
	public void save(Project_OrganisationUnit entity) {
		if (entity.getProject() == null || entity.getOrganisationUnit() == null) {
			throw new IllegalArgumentException("Please provide both a project and an organisation.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_OrganisationUnit> entityList) {
		for (Project_OrganisationUnit entity : entityList) {
			save(entity);
		}
	}
	
}
