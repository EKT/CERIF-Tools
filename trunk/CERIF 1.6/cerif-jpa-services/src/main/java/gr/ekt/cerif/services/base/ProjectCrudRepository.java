package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Project;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ProjectCrudRepository extends CrudRepository<Project, Long> {

public Project findByAcronym(String acronym);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Project findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Project> findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<Project> findAll(Pageable page);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Iterable<Project> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Project findByUuid(String uuid);
	
	@Query(
		"select p " +
		"  from Project p " +
		"  left join fetch p.projectTitles    " +
		"  left join fetch p.projectAbstracts " + 
		"  left join fetch p.projectKeywords  " +
		" where p.uuid = ?1 ")
	Project findByUuidFetchMultilingual(String uuid);
}
