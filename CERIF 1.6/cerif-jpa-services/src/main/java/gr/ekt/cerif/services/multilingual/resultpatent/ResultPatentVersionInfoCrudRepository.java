package gr.ekt.cerif.services.multilingual.resultpatent;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentVersionInfo;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPatentVersionInfoCrudRepository extends CrudRepository<ResultPatentVersionInfo, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPatentVersionInfo> findByResultPatent(ResultPatent resultPatent);

}
