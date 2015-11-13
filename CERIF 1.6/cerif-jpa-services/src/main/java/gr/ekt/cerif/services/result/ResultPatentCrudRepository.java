package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultPatent;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ResultPatentCrudRepository extends CrudRepository<ResultPatent, Long> {
	
	public List<ResultPatent> findAll();
	
	public Page<ResultPatent> findAll(Pageable page);
	
	public ResultPatent findById(Long id);

	public List<ResultPatent> findByUri(String uri);

	public ResultPatent findByUuid(String uuid);

}
