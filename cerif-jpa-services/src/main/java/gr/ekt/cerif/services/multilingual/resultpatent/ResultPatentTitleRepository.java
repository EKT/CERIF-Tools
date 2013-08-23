package gr.ekt.cerif.services.multilingual.resultpatent;

import gr.ekt.cerif.features.multilingual.ResultPatentTitle;

public interface ResultPatentTitleRepository {
	
	public void delete(ResultPatentTitle entity); 
	
	public void delete(Iterable<ResultPatentTitle> entities); 

	public Iterable<ResultPatentTitle> save(Iterable<ResultPatentTitle> entities); 
	
	public ResultPatentTitle save(ResultPatentTitle entity);

}
