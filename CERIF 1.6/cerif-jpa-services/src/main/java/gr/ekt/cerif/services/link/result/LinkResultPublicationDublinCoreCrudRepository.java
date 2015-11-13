package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.result.ResultPublication_DublinCore;
import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationDublinCoreCrudRepository extends CrudRepository<ResultPublication_DublinCore, Long> {
	
	List<ResultPublication_DublinCore> findByResultPublication(ResultPublication resultPublication);

}
