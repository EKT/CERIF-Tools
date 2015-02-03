package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationMediumCrudRepository extends CrudRepository<ResultPublication_Medium, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublication_Medium> findByResultPublication(ResultPublication resultPublication);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublication_Medium> findByMedium(Medium medium);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select mediumrespub from ResultPublication respub "+
			"  left join respub.resultPublications_mediums mediumrespub " +
			"  where respub.id = ?1   ")
	List<ResultPublication_Medium> finfByResPubId(Long respubId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select mediumrespub from ResultPublication_Medium mediumrespub "+ 
			"  where mediumrespub.id = ?1   ")
	ResultPublication_Medium findById(Long mediumrespubId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select	respubm							" +			
			"  from ResultPublication_Medium respubm		" +
			"  left join respubm.medium medium			" +
			"  where medium.id = ?1   ")
	List<ResultPublication_Medium> findByMediumId(Long mediumId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select	respubm							" +			
			"  from ResultPublication_Medium respubm		" +
			"  left join respubm.medium medium			" +
			"  left join respubm.resultPublication respubl	" +
			"  left join respubm.theClass cl			" +
			"  where medium.id = ?1 and respubl.id= ?2 and cl.uri= ?3  ")
	List<ResultPublication_Medium> findByMediumIdAndResPublIdAndClassUri(Long mediumId, Long resPublId, String classUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select	respubm							" +			
			"  from ResultPublication_Medium respubm		" +
			"  left join respubm.medium medium			" +
			"  left join respubm.resultPublication respubl	" +
			"  left join respubm.theClass cl			" +
			"  where medium.uri = ?1 and medium.mimeType = ?2 and respubl.id= ?3 and cl.uri= ?4  ")
	List<ResultPublication_Medium> findByMediumUriAndMediumMimeTypeAndResPublIdAndClassUri(String mediumUri, String mediumMimeType, Long resPublId, String classUri);
	

	
}
