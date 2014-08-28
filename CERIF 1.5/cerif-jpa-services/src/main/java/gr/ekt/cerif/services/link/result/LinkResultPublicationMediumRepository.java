package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Medium;

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
	
	public List<ResultPublication_Medium> finfByResPubId(Long respubId);
	
	public ResultPublication_Medium findById(Long mediumrespubId);
	
	public List<ResultPublication_Medium> findByMediumId(Long mediumId);
	
	public List<ResultPublication_Medium> findByResultPublication(ResultPublication resultPublication);
	
	List<ResultPublication_Medium> findByMedium(Medium medium);
	
	public List<ResultPublication_Medium> findByMediumIdAndResPublIdAndClassUri(Long mediumId, Long resPublId, String classUri);
	
	public List<ResultPublication_Medium> findByMediumUriAndMediumMimeTypeAndResPublIdAndClassUri(String mediumUri, String mediumMimeType, Long resPublId, String classUri);
	
}
