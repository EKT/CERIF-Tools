package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClassCrudRepository extends CrudRepository<Class, Long> {

	public Class findById(Long id);
    
	public List<Class> findByUri(String uri);
	
	public List<Class> findByUuid(String uuid);
	
	public List<Class> findByScheme(ClassScheme scheme);
	
	public List<Class> findAll();
	
	public Page<Class> findAll(Pageable page);
	
	public List<Class> findByUuidAndScheme(String uuid, ClassScheme scheme);
	
	@Query("select c from Class c join c.scheme s where c.uuid = ?1 and s.uuid = ?2 ")
	Class findByUuidAndSchemeUuid(String uuid, String schemeUuid);
	
	@Query("          select c from Class c      " +
		   " left join fetch c.classDescriptions " +
		   " left join fetch c.classTerms        " +
		   " left join fetch c.classDefinitions  " +
		   " left join fetch c.classExs          " +
		   "           where c.scheme = ?1       ")
	public List<Class> retrieveCompleteClassInformationForScheme(ClassScheme scheme);

}
