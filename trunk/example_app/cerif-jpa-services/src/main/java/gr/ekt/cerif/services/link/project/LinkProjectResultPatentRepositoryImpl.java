package gr.ekt.cerif.services.link.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.project.Project_ResultPatent;

@Component
public class LinkProjectResultPatentRepositoryImpl implements
		LinkProjectResultPatentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectResultPatentRepositoryImpl.class);
	
	@Autowired
	private LinkProjectResultPatentCrudRepository linkProjectResultPatentCrudRepository;

	@Override
	public void delete(Project_ResultPatent entity) {
		linkProjectResultPatentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Project_ResultPatent> entities) {
		linkProjectResultPatentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Project_ResultPatent> save(
			Iterable<Project_ResultPatent> entities) {
		return linkProjectResultPatentCrudRepository.save(entities);
	}

	@Override
	public Project_ResultPatent save(Project_ResultPatent entity) {
		return linkProjectResultPatentCrudRepository.save(entity);
	}

}
