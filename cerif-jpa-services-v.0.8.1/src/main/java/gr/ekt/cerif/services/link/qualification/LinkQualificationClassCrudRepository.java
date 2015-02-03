package gr.ekt.cerif.services.link.qualification;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Qualification_Class;
import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkQualificationClassCrudRepository extends CrudRepository<Qualification_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Qualification_Class> findByQualification(Qualification qualification);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Qualification_Class> findBytheClass(Class theClass);

}
