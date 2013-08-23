package gr.ekt.cerif.services.multilingual.resultpublication;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;

public interface ResultPublicationAbstractRepository {

	ResultPublicationAbstract findByResultPublication(ResultPublication resultPublication);
	
	public void delete(ResultPublicationAbstract entity); 
	
	public void delete(Iterable<ResultPublicationAbstract> entities); 

	public Iterable<ResultPublicationAbstract> save(Iterable<ResultPublicationAbstract> entities); 
	
	public ResultPublicationAbstract save(ResultPublicationAbstract entity);
	
}
