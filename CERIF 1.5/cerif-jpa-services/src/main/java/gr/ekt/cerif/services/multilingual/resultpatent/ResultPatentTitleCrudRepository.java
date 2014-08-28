package gr.ekt.cerif.services.multilingual.resultpatent;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentTitle;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPatentTitleCrudRepository  extends CrudRepository<ResultPatentTitle, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPatentTitle> findByResultPatent(ResultPatent resultPatent);

}
