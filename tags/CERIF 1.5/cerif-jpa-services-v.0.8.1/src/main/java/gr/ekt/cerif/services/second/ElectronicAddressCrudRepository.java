/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.features.semantics.Class;

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
	public ElectronicAddress findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Iterable<ElectronicAddress> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<ElectronicAddress> findAll(Pageable page);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select ea from ElectronicAddress ea " +
			"join ea.organisationUnits_electronicAddresses orgs " +
			"join orgs.organisationUnit org " +
			"where org=?1 ")
	public List<ElectronicAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select ea from ElectronicAddress ea " +
			"join ea.persons_electronicAddresses pers " +
			"join pers.person p " +
			"where p=?1 ")
	public List<ElectronicAddress> findByPerson(Person person);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public ElectronicAddress findByUuid(String uuid);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select ea from ElectronicAddress ea " +
			"left join ea.persons_electronicAddresses eadcl " +
			"left join eadcl.theClass cl " +
			"where ea.uri=?1 and cl=?2 ")
	public List<ElectronicAddress> findByUriAndClass(String uri, Class theClass);
	
}
