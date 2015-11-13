package gr.ekt.cerif.services.link.personname;

import gr.ekt.cerif.entities.link.PersonName_Class;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonNameClassCrudRepository extends CrudRepository<PersonName_Class, Long> {
	
	public List<PersonName_Class> findByPersonName(PersonName personName);
	
	public List<PersonName_Class> findBytheClass(Class theClass);

}
