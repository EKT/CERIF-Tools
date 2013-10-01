package gr.ekt.cerif.services.link.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.project.Project_Prize;

@Component
public class LinkProjectPrizeRepositoryImpl implements
		LinkProjectPrizeRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectPrizeRepositoryImpl.class);
	
	@Autowired
	private LinkProjectPrizeCrudRepository linkProjectPrizeAwardCrudRepository;

	@Override
	public void delete(Project_Prize entity) {
		linkProjectPrizeAwardCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Project_Prize> entities) {
		linkProjectPrizeAwardCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Project_Prize> save(
			Iterable<Project_Prize> entities) {
		return linkProjectPrizeAwardCrudRepository.save(entities);
	}

	@Override
	public Project_Prize save(Project_Prize entity) {
		return linkProjectPrizeAwardCrudRepository.save(entity);
	}

}
