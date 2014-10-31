package gr.ekt.cerif.services.multilingual.resultpatent;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPatentKeywordCrudRepository  extends CrudRepository<ResultPatentKeyword, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPatentKeyword> findByResultPatent(ResultPatent resultPatent);

}
