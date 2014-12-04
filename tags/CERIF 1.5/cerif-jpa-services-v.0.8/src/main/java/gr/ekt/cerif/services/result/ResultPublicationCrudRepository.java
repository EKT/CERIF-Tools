package gr.ekt.cerif.services.result;

import java.util.List;

import gr.ekt.cerif.entities.result.ResultPublication;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationCrudRepository extends CrudRepository<ResultPublication, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public ResultPublication findByUri(String uri);
	   
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public ResultPublication findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<ResultPublication> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<ResultPublication> findAll(Pageable page);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public ResultPublication findByUuid(String uuid);
}
