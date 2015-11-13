package gr.ekt.cerif.services.multilingual.resultpatent;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentVersionInfo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultPatentVersionInfoCrudRepository extends CrudRepository<ResultPatentVersionInfo, Long> {
	
	List<ResultPatentVersionInfo> findByResultPatent(ResultPatent resultPatent);

}
