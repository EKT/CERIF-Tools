package gr.ekt.cerif.services.link.project;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkProjectResultProductCrudRepository extends CrudRepository<Project_ResultProduct, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Project_ResultProduct> findByProject(Project project);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Project_ResultProduct> findByResultProduct(ResultProduct resultProduct);

}
