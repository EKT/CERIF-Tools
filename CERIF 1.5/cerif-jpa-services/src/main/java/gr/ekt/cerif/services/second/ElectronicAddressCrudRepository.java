/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.ElectronicAddress;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for electronic addresses.
 * 
 */
public interface ElectronicAddressCrudRepository extends CrudRepository<ElectronicAddress, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	ElectronicAddress findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Iterable<ElectronicAddress> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Page<ElectronicAddress> findAll(Pageable page);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select ea from ElectronicAddress ea " +
			"join ea.organisationUnits_electronicAddresses orgs " +
			"join orgs.organisationUnit org " +
			"where org=?1 ")
	List<ElectronicAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select ea from ElectronicAddress ea " +
			"join ea.persons_electronicAddresses pers " +
			"join pers.person p " +
			"where p=?1 ")
	List<ElectronicAddress> findByPerson(Person person);

	ElectronicAddress findByUuid(String uuid);
	
}
