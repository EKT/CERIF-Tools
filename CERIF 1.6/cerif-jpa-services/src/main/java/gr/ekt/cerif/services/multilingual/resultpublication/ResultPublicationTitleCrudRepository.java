package gr.ekt.cerif.services.multilingual.resultpublication;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationTitleCrudRepository extends CrudRepository<ResultPublicationTitle, Long>  {
	
	List<ResultPublicationTitle> findByResultPublication(ResultPublication resultPublication);

}
