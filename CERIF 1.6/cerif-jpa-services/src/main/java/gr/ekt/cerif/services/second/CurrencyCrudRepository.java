/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Currency;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for postal addresses.
 * 
 */
public interface CurrencyCrudRepository extends CrudRepository<Currency, String> {
	
	public Currency findByCode(String code);
	
	public Currency findByUri(String uri);
	
	public Currency findByUuid(String uuid);
	
	public List<Currency> findAll();
	
	public Page<Currency> findAll(Pageable page);

}
