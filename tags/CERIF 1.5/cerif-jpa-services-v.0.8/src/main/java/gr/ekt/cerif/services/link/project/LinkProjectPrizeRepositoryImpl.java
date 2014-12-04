package gr.ekt.cerif.services.link.project;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Prize;
import gr.ekt.cerif.entities.second.Prize;

@Component
public class LinkProjectPrizeRepositoryImpl implements
		LinkProjectPrizeRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectPrizeRepositoryImpl.class);
	
	@Autowired
	private LinkProjectPrizeCrudRepository linkProjectPrizeCrudRepository;

	@Override
	public void delete(Project_Prize entity) {
		linkProjectPrizeCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Project_Prize> entities) {
		linkProjectPrizeCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Project_Prize> save(
			Iterable<Project_Prize> entities) {
		return linkProjectPrizeCrudRepository.save(entities);
	}

	@Override
	public Project_Prize save(Project_Prize entity) {
		return linkProjectPrizeCrudRepository.save(entity);
	}

	@Override
	public List<Project_Prize> findByProject(Project project) {
		return linkProjectPrizeCrudRepository.findByProject(project);
	}

	@Override
	public List<Project_Prize> findByPrize(Prize Prize) {
		return linkProjectPrizeCrudRepository.findByPrize(Prize);
	}

}
