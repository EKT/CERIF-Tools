/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.PostalAddress;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface PostalAddressCrudRepository extends CrudRepository<PostalAddress, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<PostalAddress> findByCountry(Country country);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Iterable<PostalAddress> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<PostalAddress> findAll(Pageable page);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public PostalAddress findByUuid(String uuid);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public PostalAddress findById(Long id);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<PostalAddress> findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select pa from PostalAddress pa " +
			"join pa.organisationUnits_postalAddresses orgs " +
			"join orgs.organisationUnit org " +
			"where org=?1 ")
	public List<PostalAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select pa from PostalAddress pa " +
			"join pa.equipments_postalAddresses equips " +
			"join equips.equipment equip " +
			"where equip=?1 ")
	public  List<PostalAddress> findByEquipment(Equipment equipment);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select pa from PostalAddress pa " +
			"join pa.facilities_postalAddresses facs " +
			"join facs.facility fac " +
			"where fac=?1 ")
	public List<PostalAddress> findByFacility(Facility facility);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select pa from PostalAddress pa " +
			"join pa.services_postalAddresses srvs " +
			"join srvs.service serv " +
			"where serv=?1 ")
	public List<PostalAddress> findByService(Service service);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select pa from PostalAddress pa join pa.persons_postalAddresses pp join pp.person per where per=?1")
	public List<PostalAddress> findByPerson(Person person);

	
}
