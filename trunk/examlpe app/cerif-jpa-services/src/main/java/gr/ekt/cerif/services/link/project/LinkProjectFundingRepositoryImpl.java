package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.services.base.ProjectRepository;
import gr.ekt.cerif.services.second.FundingRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkProjectFundingRepositoryImpl implements LinkProjectFundingRepository {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Autowired
	private LinkProjectFundingCrudRepository linkProjectFundingCrudRepository;
	
	@Transactional
	public Project_Funding save(Project_Funding entity) {
		if (entity.getProject() == null || entity.getFunding() == null) {
			throw new IllegalArgumentException("Please provide both a project and a funding.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		return linkProjectFundingCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<? extends Project_Funding> save(Iterable<? extends Project_Funding> entityList) {
		return linkProjectFundingCrudRepository.save(entityList);
	}

	@Transactional
	public void delete(Project_Funding entity) {
		linkProjectFundingCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<Project_Funding> entities) {
		linkProjectFundingCrudRepository.delete(entities);
	}
	
	public List<Project_Funding> findByProject(Project project) {
		return linkProjectFundingCrudRepository.findByProject(project);
	}

	public List<Project_Funding> findByFunding(Funding funding) {
		return linkProjectFundingCrudRepository.findByFunding(funding);
	}
	
}
