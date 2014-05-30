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
	ResultPublication findByUri(String uri);
	   
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	ResultPublication findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublication> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Page<ResultPublication> findAll(Pageable page);

	ResultPublication findByUuid(String uuid);
}
