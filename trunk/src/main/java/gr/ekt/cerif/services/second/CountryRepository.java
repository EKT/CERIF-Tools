/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Country;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for countries.
 * 
 */
public interface CountryRepository extends CrudRepository<Country, String> {

	Country findByCode(String code);
	
	Country findByUri(String uri);
	
	List<Country> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("Select c from gr.ekt.cerif.entities.second.Country c join c.names n where n.name=?1")
	Country findByCountryName(String CountryName);
		
}
