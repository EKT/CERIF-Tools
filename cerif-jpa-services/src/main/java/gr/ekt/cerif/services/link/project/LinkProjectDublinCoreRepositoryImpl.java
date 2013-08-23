package gr.ekt.cerif.services.link.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.project.Project_DublinCore;

@Component
public class LinkProjectDublinCoreRepositoryImpl implements
		LinkProjectDublinCoreRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectDublinCoreRepositoryImpl.class);
	
	@Autowired
	private LinkProjectDublinCoreCrudRepository linkProjectDublinCoreCrudRepository;

	@Override
	public void delete(Project_DublinCore entity) {
		linkProjectDublinCoreCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Project_DublinCore> entities) {
		linkProjectDublinCoreCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Project_DublinCore> save(
			Iterable<Project_DublinCore> entities) {
		return linkProjectDublinCoreCrudRepository.save(entities);
	}

	@Override
	public Project_DublinCore save(Project_DublinCore entity) {
		return linkProjectDublinCoreCrudRepository.save(entity);
	}

}
