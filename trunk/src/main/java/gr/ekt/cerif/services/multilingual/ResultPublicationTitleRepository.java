package gr.ekt.cerif.services.multilingual;

import javax.persistence.QueryHint;

import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationTitleRepository extends CrudRepository<ResultPublicationTitle, String> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select respubt from ResultPublication respub "+
			"  left join respub.resultPublicationTitles respubt		" +
			"  where respub.id = ?1")
	ResultPublicationTitle findTitleById(Long Id);
}
