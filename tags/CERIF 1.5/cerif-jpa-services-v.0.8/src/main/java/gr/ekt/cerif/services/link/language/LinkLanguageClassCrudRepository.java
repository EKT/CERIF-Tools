package gr.ekt.cerif.services.link.language;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Language_Class;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkLanguageClassCrudRepository extends CrudRepository<Language_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Language_Class> findByLanguage(Language language);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Language_Class> findBytheClass(Class theClass);

}
