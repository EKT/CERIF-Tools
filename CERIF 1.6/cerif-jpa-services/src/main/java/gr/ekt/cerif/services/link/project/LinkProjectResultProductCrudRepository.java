package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectResultProductCrudRepository extends CrudRepository<Project_ResultProduct, Long> {
	
	List<Project_ResultProduct> findByProject(Project project);
	
	List<Project_ResultProduct> findByResultProduct(ResultProduct resultProduct);

}
