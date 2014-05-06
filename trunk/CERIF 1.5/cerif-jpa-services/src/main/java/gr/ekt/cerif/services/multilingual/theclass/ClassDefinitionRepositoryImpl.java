/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.semantics.Class;

/**
 * @author bonisv
 *
 */
@Component
public class ClassDefinitionRepositoryImpl implements ClassDefinitionRepository {

	private static final Logger log = LoggerFactory.getLogger(ClassDefinitionRepositoryImpl.class);
	
	@Autowired
	private ClassDefinitionCrudRepository classDefinitionCrudRepository;
	
	@Override
	public void delete(ClassDefinition entity) {
		classDefinitionCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<ClassDefinition> entities) {
		classDefinitionCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<ClassDefinition> save(Iterable<ClassDefinition> entities) {
		return classDefinitionCrudRepository.save(entities);
	}

	@Override
	public ClassDefinition save(ClassDefinition entity) {
		return classDefinitionCrudRepository.save(entity);
	}

	@Override
	public List<ClassDefinition> findByTheClass(Class theClass) {
		return classDefinitionCrudRepository.findByTheClass(theClass);
	}

}
