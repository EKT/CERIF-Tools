/**
 * 
 */
package gr.ekt.cerif.services.multilingual.classscheme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;

/**
 * @author bonisv
 *
 */
@Component
public class ClassSchemeDescriptionRepositoryImpl implements ClassSchemeDescriptionRepository {

	private static final Logger log = LoggerFactory.getLogger(ClassSchemeDescriptionRepositoryImpl.class);

	@Autowired
	private ClassSchemeDescriptionCrudRepository classSchemeDescriptionCrudRepository;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ClassSchemeDescriptionRepository#delete(gr.ekt.cerif.features.multilingual.ClassSchemeDescription)
	 */
	@Override
	public void delete(ClassSchemeDescription entity) {
		classSchemeDescriptionCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ClassSchemeDescriptionRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<ClassSchemeDescription> entities) {
		classSchemeDescriptionCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ClassSchemeDescriptionRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<ClassSchemeDescription> save(Iterable<ClassSchemeDescription> entities) {
		return classSchemeDescriptionCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ClassSchemeDescriptionRepository#save(gr.ekt.cerif.features.multilingual.ClassSchemeDescription)
	 */
	@Override
	public ClassSchemeDescription save(ClassSchemeDescription entity) {
		return classSchemeDescriptionCrudRepository.save(entity);
	}

}
