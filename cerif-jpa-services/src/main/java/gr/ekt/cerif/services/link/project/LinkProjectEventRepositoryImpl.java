package gr.ekt.cerif.services.link.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.project.Project_Event;

@Component
public class LinkProjectEventRepositoryImpl implements
		LinkProjectEventRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectEventRepositoryImpl.class);
	
	@Autowired
	private LinkProjectEventCrudRepository linkProjectEventCrudRepository;

	@Override
	public void delete(Project_Event entity) {
		linkProjectEventCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Project_Event> entities) {
		linkProjectEventCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Project_Event> save(Iterable<Project_Event> entities) {
		return linkProjectEventCrudRepository.save(entities);
	}

	@Override
	public Project_Event save(Project_Event entity) {
		return linkProjectEventCrudRepository.save(entity);
	}

}
