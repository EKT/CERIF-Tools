package gr.ekt.cerif.services.multilingual.resultpatent;

import java.util.List;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentVersionInfo;

public interface ResultPatentVersionInfoRepository {
	
	public void delete(ResultPatentVersionInfo entity); 
	
	public void delete(Iterable<ResultPatentVersionInfo> entities); 

	public Iterable<ResultPatentVersionInfo> save(Iterable<ResultPatentVersionInfo> entities); 
	
	public ResultPatentVersionInfo save(ResultPatentVersionInfo entity);
	
	List<ResultPatentVersionInfo> findByResultPatent(ResultPatent resultPatent);

}
