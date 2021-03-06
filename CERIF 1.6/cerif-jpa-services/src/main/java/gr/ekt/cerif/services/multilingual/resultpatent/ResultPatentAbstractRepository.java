package gr.ekt.cerif.services.multilingual.resultpatent;

import java.util.List;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentAbstract;

public interface ResultPatentAbstractRepository {
	
	public void delete(ResultPatentAbstract entity); 
	
	public void delete(Iterable<ResultPatentAbstract> entities); 

	public Iterable<ResultPatentAbstract> save(Iterable<ResultPatentAbstract> entities); 
	
	public ResultPatentAbstract save(ResultPatentAbstract entity);
	
	List<ResultPatentAbstract> findByResultPatent(ResultPatent resultPatent);

}
