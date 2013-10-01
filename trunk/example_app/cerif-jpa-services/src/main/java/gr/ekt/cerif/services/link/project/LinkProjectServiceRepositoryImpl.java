package gr.ekt.cerif.services.link.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.project.Project_Service;

@Component
public class LinkProjectServiceRepositoryImpl implements
		LinkProjectServiceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectServiceRepositoryImpl.class);
	
	@Autowired
	private LinkProjectServiceCrudRepository linkProjectServiceCrudRepository;

	@Override
	public void delete(Project_Service entity) {
		linkProjectServiceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Project_Service> entities) {
		linkProjectServiceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Project_Service> save(Iterable<Project_Service> entities) {
		return linkProjectServiceCrudRepository.save(entities);
	}

	@Override
	public Project_Service save(Project_Service entity) {
		return linkProjectServiceCrudRepository.save(entity);
	}

}
