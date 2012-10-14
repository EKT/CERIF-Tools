package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Class_Class;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between classes and classes.
 * 
 */
public interface LinkClassClassRepository extends CrudRepository<Class_Class, Long>{		
}

