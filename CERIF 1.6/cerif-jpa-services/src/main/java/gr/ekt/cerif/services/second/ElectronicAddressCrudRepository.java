/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for electronic addresses.
 * 
 */
public interface ElectronicAddressCrudRepository extends CrudRepository<ElectronicAddress, Long> {
	
	public ElectronicAddress findByUri(String uri);
	
	public Iterable<ElectronicAddress> findAll();
	
	public Page<ElectronicAddress> findAll(Pageable page);
	
	@Query("select ea from ElectronicAddress ea " +
			"join ea.organisationUnits_electronicAddresses orgs " +
			"join orgs.organisationUnit org " +
			"where org=?1 ")
	public List<ElectronicAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	@Query("select ea from ElectronicAddress ea " +
			"join ea.persons_electronicAddresses pers " +
			"join pers.person p " +
			"where p=?1 ")
	public List<ElectronicAddress> findByPerson(Person person);

	public ElectronicAddress findByUuid(String uuid);
	
	@Query("select ea from ElectronicAddress ea " +
			"left join ea.persons_electronicAddresses eadcl " +
			"left join eadcl.theClass cl " +
			"where ea.uri=?1 and cl=?2 ")
	public List<ElectronicAddress> findByUriAndClass(String uri, Class theClass);
	
}
