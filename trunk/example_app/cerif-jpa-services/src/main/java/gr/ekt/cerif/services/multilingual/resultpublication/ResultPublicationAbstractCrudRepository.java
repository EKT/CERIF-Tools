package gr.ekt.cerif.services.multilingual.resultpublication;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationAbstractCrudRepository extends CrudRepository<ResultPublicationAbstract, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	ResultPublicationAbstract findByResultPublication(ResultPublication resultPublication);
	
}
