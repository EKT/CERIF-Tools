package gr.ekt.cerif.services.link.personname;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.PersonName_Class;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkPersonNameClassCrudRepository extends CrudRepository<PersonName_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<PersonName_Class> findByPersonName(PersonName personName);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<PersonName_Class> findBytheClass(Class theClass);

}
