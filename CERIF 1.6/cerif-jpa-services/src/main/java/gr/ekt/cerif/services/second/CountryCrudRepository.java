/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Country;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface CountryCrudRepository extends CrudRepository<Country, String> {
	
	public Country findByCode(String code);
	
	public Country findByUri(String uri);
	
	public List<Country> findAll();
	
	public Page<Country> findAll(Pageable page);

	public Country findByUuid(String uuid);
	
}
