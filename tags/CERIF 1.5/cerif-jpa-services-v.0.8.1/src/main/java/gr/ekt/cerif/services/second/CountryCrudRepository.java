/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Country;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface CountryCrudRepository extends CrudRepository<Country, String> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Country findByCode(String code);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Country findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Country> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<Country> findAll(Pageable page);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Country findByUuid(String uuid);
	
}
