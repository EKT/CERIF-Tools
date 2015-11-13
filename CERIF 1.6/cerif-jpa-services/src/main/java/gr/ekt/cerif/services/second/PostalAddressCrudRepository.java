/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.PostalAddress;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface PostalAddressCrudRepository extends CrudRepository<PostalAddress, Long> {

	public List<PostalAddress> findByCountry(Country country);
	
	public Iterable<PostalAddress> findAll();
	
	public Page<PostalAddress> findAll(Pageable page);

	public PostalAddress findByUuid(String uuid);
	
	public PostalAddress findById(Long id);

	public List<PostalAddress> findByUri(String uri);
	
	@Query("select pa from PostalAddress pa " +
			"join pa.organisationUnits_postalAddresses orgs " +
			"join orgs.organisationUnit org " +
			"where org=?1 ")
	public List<PostalAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	@Query("select pa from PostalAddress pa " +
			"join pa.equipments_postalAddresses equips " +
			"join equips.equipment equip " +
			"where equip=?1 ")
	public  List<PostalAddress> findByEquipment(Equipment equipment);
	
	@Query("select pa from PostalAddress pa " +
			"join pa.facilities_postalAddresses facs " +
			"join facs.facility fac " +
			"where fac=?1 ")
	public List<PostalAddress> findByFacility(Facility facility);
	
	@Query("select pa from PostalAddress pa " +
			"join pa.services_postalAddresses srvs " +
			"join srvs.service serv " +
			"where serv=?1 ")
	public List<PostalAddress> findByService(Service service);

	@Query("select pa from PostalAddress pa join pa.persons_postalAddresses pp join pp.person per where per=?1")
	public List<PostalAddress> findByPerson(Person person);

	
}
