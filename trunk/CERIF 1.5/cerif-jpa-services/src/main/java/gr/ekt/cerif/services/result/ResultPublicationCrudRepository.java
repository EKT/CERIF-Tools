package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultPublication;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationCrudRepository extends CrudRepository<ResultPublication, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	ResultPublication findByUri(String uri);
	   
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	ResultPublication findById(Long id);
}
