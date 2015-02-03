package gr.ekt.cerif.services.multilingual.resultpublication;


import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationKeywordCrudRepository extends CrudRepository<ResultPublicationKeyword, Long>  {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublicationKeyword> findByResultPublication(ResultPublication resultPublication);
	
}
