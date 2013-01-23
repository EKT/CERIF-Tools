package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.entities.result.ResultPublication;

import java.util.List;

/**
 * A repository for links between resultPublications and mediums.
 * 
 */
public interface LinkResultPublicationMediumRepository {
	
	ResultPublication_Medium save(ResultPublication_Medium entity);
	
	Iterable<ResultPublication_Medium> save(Iterable<ResultPublication_Medium> entityList);
	
	void delete(ResultPublication_Medium entity);

	void delete(Iterable<ResultPublication_Medium> entityList);
	
	List<ResultPublication_Medium> queryMediumResPubByResPubId(Long respubId);
	
	ResultPublication_Medium queryMediumResPubById(Long mediumrespubId);
	
	ResultPublication_Medium findByMediumId(Long mediumId);
	
	List<ResultPublication_Medium> findByResultPublication(ResultPublication resultPublication);
	
}
