/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.services.second.FundingRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and fundings.
 * 
 */
@Component
public class LinkProjectFundingRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Transactional
	public void save(Project_Funding entity) {
		if (entity.getProject() == null || entity.getFunding() == null) {
			throw new IllegalArgumentException("Please provide both a project and a funding.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_Funding> entityList) {
		for (Project_Funding entity : entityList) {
			save(entity);
		}
	}
	
}
