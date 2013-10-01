package gr.ekt.cerif.services.link.theclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Class_Class;
import gr.ekt.cerif.features.semantics.Class;

@Component
public class LinkClassClassRepositoryImpl implements LinkClassClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkClassClassRepositoryImpl.class);
	
	@Autowired
	private LinkClassClassCrudRepository linkClassClassCrudRepository;

	@Override
	public Class_Class findBytheClass1AndtheClass2(Class theClass1,
			Class theClass2) {
		return linkClassClassCrudRepository.findBytheClass1AndtheClass2(theClass1, theClass2);
	}

	@Override
	public void delete(Class_Class entity) {
		linkClassClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Class_Class> entities) {
		linkClassClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Class_Class> save(Iterable<Class_Class> entities) {
		return linkClassClassCrudRepository.save(entities);
	}

	@Override
	public Class_Class save(Class_Class entity) {
		return linkClassClassCrudRepository.save(entity);
	}

}
