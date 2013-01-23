package gr.ekt.cerif.services.multilingual;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationAbstractRepository extends CrudRepository<ResultPublicationAbstract, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select respubab from ResultPublication respub "+
			"  left join respub.resultPublicationAbstracts respubab		" +
			"  where respub.id = ?1")
	ResultPublicationAbstract findAbstractById(Long Id);
	
	ResultPublicationAbstract findByResultPublication(ResultPublication resultPublication);
	
}
