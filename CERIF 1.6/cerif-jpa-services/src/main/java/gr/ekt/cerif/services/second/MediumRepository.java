package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.Medium;

public interface MediumRepository {
	
	Medium findById(Long id);
	
	Medium findByUri(String uri);
	
	void delete(Medium entity);
	
	void delete(Iterable<Medium> entityList);
	
	Iterable<Medium> save(Iterable<Medium> entities);
	
	Medium save(Medium entity);
	
	Medium findMediumByProjectIdAndClassUUID(Long id, String uuid);
	
	Medium findMediumByOrgIdAndClassUUID(Long id, String uuid);
	
	Medium findMediumByPersonIdAndClassUUID(Long id, String uuid);
	
	List<Medium> findAll();
	
	Page<Medium> findAll(Pageable page);
	
	Medium findByUuid(String uuid);
}
