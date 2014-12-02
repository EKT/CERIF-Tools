package gr.ekt.cerif.services.link.project;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

@Component
public class LinkProjectIndicatorRepositoryImpl implements
		LinkProjectIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkProjectIndicatorCrudRepository linkProjectIndicatorCrudRepository;

	@Override
	public void delete(Project_Indicator entity) {
		linkProjectIndicatorCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Project_Indicator> entities) {
		linkProjectIndicatorCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Project_Indicator> save(Iterable<Project_Indicator> entities) {
		return linkProjectIndicatorCrudRepository.save(entities);
	}

	@Override
	public Project_Indicator save(Project_Indicator entity) {
		return linkProjectIndicatorCrudRepository.save(entity);
	}

	@Override
	public List<Project_Indicator> findByProject(Project project) {
		return linkProjectIndicatorCrudRepository.findByProject(project);
	}

	@Override
	public List<Project_Indicator> findByIndicator(Indicator indicator) {
		return linkProjectIndicatorCrudRepository.findByIndicator(indicator);
	}

}
