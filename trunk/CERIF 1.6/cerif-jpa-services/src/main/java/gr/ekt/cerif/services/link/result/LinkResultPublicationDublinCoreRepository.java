package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPublication_DublinCore;
import gr.ekt.cerif.entities.result.ResultPublication;

/**
 * A repository for links between resultPublications and dublinCores.
 * 
 */
public interface LinkResultPublicationDublinCoreRepository {

	public void delete(ResultPublication_DublinCore entity); 
	
	public void delete(Iterable<ResultPublication_DublinCore> entities); 

	public Iterable<ResultPublication_DublinCore> save(Iterable<ResultPublication_DublinCore> entities); 
	
	public ResultPublication_DublinCore save(ResultPublication_DublinCore entity);
	
	List<ResultPublication_DublinCore> findByResultPublication(ResultPublication resultPublication);
	
}
