package gr.ekt.cerif.services.multilingual;

import javax.persistence.QueryHint;

import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationKeywordRepository extends CrudRepository<ResultPublicationKeyword, String> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select respubkey from ResultPublication respub "+
			"  left join respub.resultPublicationKeywords respubkey		" +
			"  where respub.id = ?1")
	ResultPublicationKeyword findKeywordsById(Long Id);
}
