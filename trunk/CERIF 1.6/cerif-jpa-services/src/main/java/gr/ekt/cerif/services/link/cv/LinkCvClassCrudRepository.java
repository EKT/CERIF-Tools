package gr.ekt.cerif.services.link.cv;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Cv_Class;
import gr.ekt.cerif.entities.second.CV;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkCvClassCrudRepository extends CrudRepository<Cv_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Cv_Class> findByCv(CV cv);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Cv_Class> findBytheClass(Class theClass);

}
