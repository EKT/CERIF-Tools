package gr.ekt.cerif.services.multilingual.resultpatent;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentTitle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultPatentTitleCrudRepository  extends CrudRepository<ResultPatentTitle, Long> {
	
	List<ResultPatentTitle> findByResultPatent(ResultPatent resultPatent);

}
