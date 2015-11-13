package gr.ekt.cerif.services.link.prize;

import gr.ekt.cerif.entities.link.Prize_Class;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPrizeClassCrudRepository extends CrudRepository<Prize_Class, Long> {
	
	List<Prize_Class> findByPrize(Prize prize);
	
	List<Prize_Class> findBytheClass(Class theClass);

}
