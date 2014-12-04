package gr.ekt.cerif.services.link.prize;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Prize_Class;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkPrizeClassCrudRepository extends CrudRepository<Prize_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Prize_Class> findByPrize(Prize prize);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Prize_Class> findBytheClass(Class theClass);

}
