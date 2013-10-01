package gr.ekt.cerif.services.multilingual.resultproduct;

import gr.ekt.cerif.features.multilingual.ResultProductVersionInfo;

public interface ResultProductVersionInfoRepository {
	
	public void delete(ResultProductVersionInfo entity); 
	
	public void delete(Iterable<ResultProductVersionInfo> entities); 

	public Iterable<ResultProductVersionInfo> save(Iterable<ResultProductVersionInfo> entities); 
	
	public ResultProductVersionInfo save(ResultProductVersionInfo entity);

}
