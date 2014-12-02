package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

/**
 * A repository for links between resultPublications and classes.
 * 
 */
public interface LinkResultPublicationClassRepository {
	
	public ResultPublication_Class save(ResultPublication_Class entity);
	
	public Iterable<ResultPublication_Class> save(Iterable<ResultPublication_Class> entityList);
	
	public void delete(ResultPublication_Class entity);
	
	public void delete(Iterable<ResultPublication_Class> entityList);
	
	List<ResultPublication_Class> findByResultPublication(ResultPublication resultPublication);
	
	List<ResultPublication_Class> findBytheClass(Class theClass);
	
	public List<ResultPublication_Class> findByResPublIdAndClScheme(Long respubId, String schUri);
	
	public ResultPublication_Class findById(Long respubclId);
	
	public ResultPublication_Class findByResPubIdAndClassId(Long respubId, Long clId);
	
	public List<ResultPublication_Class> findByResPubId(Long respubId);
	
	public ResultPublication_Class findResPubClassBySchemeUriAndResPubId(String schemeUri, Long respubId);
}
