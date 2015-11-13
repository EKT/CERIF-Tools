package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationClassCrudRepository extends CrudRepository<ResultPublication_Class, Long> {
	
	List<ResultPublication_Class> findByResultPublication(ResultPublication resultPublication);
	
	List<ResultPublication_Class> findBytheClass(Class theClass);
	
	@Query(value = "select respubc from ResultPublication respub "+
			"  left join respub.resultPublications_classes respubc " +
			"  join respubc.theClass cl " +
			"  join cl.scheme sch " +
			"  where respub.id = ?1 and sch.uri= ?2 ")
	List<ResultPublication_Class> findByResPublIdAndClScheme(Long respubId, String schUri);
	
	@Query(value = "select respubc from ResultPublication_Class respubc "+
			"  where respubc.id = ?1")
	ResultPublication_Class findById(Long respubclId);
	
	@Query(value = "select respubc from ResultPublication respub "+
			"  left join respub.resultPublications_classes respubc " +
			"  join respubc.theClass cl " +
			"  where respub.id = ?1 and cl.id= ?2 ")
	ResultPublication_Class findByResPubIdAndClassId(Long respubId, Long clId);	
	
	@Query(value = "select respubc from ResultPublication respub "+
			"  left join respub.resultPublications_classes respubc " +
			"  where respub.id = ?1 ")
	List<ResultPublication_Class> findByResPubId(Long respubId);	
	
	@Query(value = "select respubcls									" +
			   "  from ResultPublication respub 						" +
			   "  left join respub.resultPublications_classes respubcls	" +
			   "  left join respubcls.theClass cl						" +
			   "  left join cl.scheme scheme							" +
			   "  where scheme.uri=?1 and respub.id=?2")
	ResultPublication_Class findResPubClassBySchemeUriAndResPubId(String schemeUri, Long respubId);

}
