package gr.ekt.cerif.services.multilingual.resultpatent;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultPatentKeywordCrudRepository  extends CrudRepository<ResultPatentKeyword, Long> {
	
	List<ResultPatentKeyword> findByResultPatent(ResultPatent resultPatent);

}
