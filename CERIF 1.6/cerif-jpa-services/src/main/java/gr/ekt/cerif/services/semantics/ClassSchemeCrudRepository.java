package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ClassSchemeCrudRepository extends CrudRepository<ClassScheme, Long> {
	
	public ClassScheme findById(Long id);

	public ClassScheme findByUri(String uri);
	
	public List<ClassScheme> findAll();
	
	public Page<ClassScheme> findAll(Pageable page);
	
	public ClassScheme findByUuid(String uuid);
	
}
