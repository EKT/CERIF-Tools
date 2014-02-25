/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

/**
 * A repository for links between projects and ResultProducts.
 * 
 */
public interface LinkProjectResultProductRepository {

	public void delete(Project_ResultProduct entity); 
	
	public void delete(Iterable<Project_ResultProduct> entities); 

	public Iterable<Project_ResultProduct> save(Iterable<Project_ResultProduct> entities); 
	
	public Project_ResultProduct save(Project_ResultProduct entity);
	
	List<Project_ResultProduct> findByProject(Project project);
	
	List<Project_ResultProduct> findByResultProduct(ResultProduct resultProduct);
	
}
