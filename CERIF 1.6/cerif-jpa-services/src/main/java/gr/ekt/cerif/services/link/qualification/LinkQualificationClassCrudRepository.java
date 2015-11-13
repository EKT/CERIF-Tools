package gr.ekt.cerif.services.link.qualification;

import gr.ekt.cerif.entities.link.Qualification_Class;
import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkQualificationClassCrudRepository extends CrudRepository<Qualification_Class, Long> {
	
	List<Qualification_Class> findByQualification(Qualification qualification);
	
	List<Qualification_Class> findBytheClass(Class theClass);

}
