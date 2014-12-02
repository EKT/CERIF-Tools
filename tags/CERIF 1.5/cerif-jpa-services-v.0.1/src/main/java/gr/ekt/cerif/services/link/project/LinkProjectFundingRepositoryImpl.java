package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.second.Funding;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkProjectFundingRepositoryImpl implements LinkProjectFundingRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectFundingRepositoryImpl.class);
	
	@Autowired
	private LinkProjectFundingCrudRepository linkProjectFundingCrudRepository;
	
	@Transactional
	public Project_Funding save(Project_Funding entity) {
		return linkProjectFundingCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<Project_Funding> save(Iterable<Project_Funding> entityList) {
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
