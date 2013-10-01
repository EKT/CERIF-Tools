package gr.ekt.cerif.services.multilingual.resultpublication;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationTitleCrudRepository extends CrudRepository<ResultPublicationTitle, Long>  {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	ResultPublicationTitle findByResultPublication(ResultPublication resultPublication);

}
