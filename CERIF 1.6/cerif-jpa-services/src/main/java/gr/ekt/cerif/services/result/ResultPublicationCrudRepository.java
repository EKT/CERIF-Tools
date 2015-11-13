package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultPublication;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationCrudRepository extends CrudRepository<ResultPublication, Long> {

	public ResultPublication findByUri(String uri);
	   
	public ResultPublication findById(Long id);
	
	public List<ResultPublication> findAll();
	
	public Page<ResultPublication> findAll(Pageable page);

	public ResultPublication findByUuid(String uuid);
}
