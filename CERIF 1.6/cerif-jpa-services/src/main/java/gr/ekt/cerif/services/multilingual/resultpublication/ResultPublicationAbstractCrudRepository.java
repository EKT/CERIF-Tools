package gr.ekt.cerif.services.multilingual.resultpublication;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationAbstractCrudRepository extends CrudRepository<ResultPublicationAbstract, Long> {

	List<ResultPublicationAbstract> findByResultPublication(ResultPublication resultPublication);
	
}
