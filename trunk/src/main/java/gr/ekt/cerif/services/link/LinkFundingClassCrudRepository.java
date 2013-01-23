package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFundingClassCrudRepository extends CrudRepository<Funding_Class, Long> {

	List<Funding_Class> findByTheClass(Class theClass);

	List<Funding_Class> findByTheClassAndFunding(Class theClass, Funding funding);
	
}
