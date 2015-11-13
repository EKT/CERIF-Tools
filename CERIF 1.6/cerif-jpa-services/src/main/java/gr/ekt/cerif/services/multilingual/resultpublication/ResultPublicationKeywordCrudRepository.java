package gr.ekt.cerif.services.multilingual.resultpublication;


import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationKeywordCrudRepository extends CrudRepository<ResultPublicationKeyword, Long>  {
	
	List<ResultPublicationKeyword> findByResultPublication(ResultPublication resultPublication);
	
}
