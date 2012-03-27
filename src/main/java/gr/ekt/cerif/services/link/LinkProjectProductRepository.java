/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.services.base.ProjectRepository;
import gr.ekt.cerif.services.result.ResultProductRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and products.
 * 
 */
@Component
public class LinkProjectProductRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ResultProductRepository productRepository;
	
	@Transactional
	public void save(Project_ResultProduct entity) {
		if (entity.getProject() == null || entity.getResultProduct() == null) {
			throw new IllegalArgumentException("Please provide both a project and a product.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getResultProduct().getId() == null) {
			productRepository.save(entity.getResultProduct());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_ResultProduct> entityList) {
		for (Project_ResultProduct entity : entityList) {
			save(entity);
		}
	}
	
}
