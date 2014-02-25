package gr.ekt.cerif.services.link.project;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

@Component
public class LinkProjectResultProductRepositoryImpl implements
		LinkProjectResultProductRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProjectResultProductRepositoryImpl.class);
	
	@Autowired
	private LinkProjectResultProductCrudRepository linkProjectResultProductCrudRepository;

	@Override
	public void delete(Project_ResultProduct entity) {
		linkProjectResultProductCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Project_ResultProduct> entities) {
		linkProjectResultProductCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Project_ResultProduct> save(
			Iterable<Project_ResultProduct> entities) {
		return linkProjectResultProductCrudRepository.save(entities);
	}

	@Override
	public Project_ResultProduct save(Project_ResultProduct entity) {
		return linkProjectResultProductCrudRepository.save(entity);
	}

	@Override
	public List<Project_ResultProduct> findByProject(Project project) {
		return linkProjectResultProductCrudRepository.findByProject(project);
	}

	@Override
	public List<Project_ResultProduct> findByResultProduct(
			ResultProduct resultProduct) {
		return linkProjectResultProductCrudRepository.findByResultProduct(resultProduct);
	}

}
