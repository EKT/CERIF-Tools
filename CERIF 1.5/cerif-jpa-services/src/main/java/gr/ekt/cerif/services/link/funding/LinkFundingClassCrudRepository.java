package gr.ekt.cerif.services.link.funding;

import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkFundingClassCrudRepository extends CrudRepository<Funding_Class, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Funding_Class> findByTheClass(Class theClass);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Funding_Class> findByTheClassAndFunding(Class theClass, Funding funding);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Funding_Class> findByFunding(Funding funding);
	
}
