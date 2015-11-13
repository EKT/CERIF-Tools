/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.CurriculumVitae;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author bonisv
 *
 */
public interface FederatedIdentifierRepository {

	void delete(FederatedIdentifier entity); 
	
	void delete(Iterable<FederatedIdentifier> entities); 

	Iterable<FederatedIdentifier> save(Iterable<FederatedIdentifier> entities); 
	
	FederatedIdentifier save(FederatedIdentifier entity);	
	
	List<FederatedIdentifier> findAll();
	
	Page<FederatedIdentifier> findAll(Pageable page);
	
	List<FederatedIdentifier> findFedIdByClassUriAndInstId(String classUri, Long instanceId);
	
	List<FederatedIdentifier> findFedIdByClassUuidAndInstId(String classUuid, Long instanceId);
	
	List<FederatedIdentifier> findFedIdByClassClassSchemeInstIdAndFedId(Class theClass, ClassScheme classScheme, Long instanceId, String fedId);
	
	List<FederatedIdentifier> findFedIdByClassClassSchemeAndFedId(Class theClass, String fedId, Class fedType);
	
	FederatedIdentifier findByUuid(String uuid);
	
	FederatedIdentifier findById(Long id);
	
	List<FederatedIdentifier> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<FederatedIdentifier> findByResultPublication(ResultPublication resultPublication);
	
	List<FederatedIdentifier> findByPerson(Person person);
	
	List<FederatedIdentifier> findByProject(Project project);
	
	List<FederatedIdentifier> findByEquipment(Equipment equipment);
	
	List<FederatedIdentifier> findByFacility(Facility facility);
	
	List<FederatedIdentifier> findByService(Service service);
	
	List<FederatedIdentifier> findByResultPatent(ResultPatent resultPatent);
	
	List<FederatedIdentifier> findByResultProduct(ResultProduct resultProduct);
	
	List<FederatedIdentifier> findByCitation(Citation citation);
	
	List<FederatedIdentifier> findByCurriculumVitae(CurriculumVitae curriculumVitae);
	
	List<FederatedIdentifier> findByElectronicAddress(ElectronicAddress electronicAddress);
	
	List<FederatedIdentifier> findByEvent(Event event);
	
	List<FederatedIdentifier> findByExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills);
	
	List<FederatedIdentifier> findByFunding(Funding funding);
	
	List<FederatedIdentifier> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
	
	List<FederatedIdentifier> findByMeasurement(Measurement measurement);
	
	List<FederatedIdentifier> findByMedium(Medium medium);
	
	List<FederatedIdentifier> findByPostalAddress(PostalAddress postalAddress);
	
	List<FederatedIdentifier> findByMetrics(Metrics metrics);
	
	List<FederatedIdentifier> findByPrize(Prize prize);
	
	List<FederatedIdentifier> findByIndicator(Indicator indicator);
	
	List<FederatedIdentifier> findByQualification(Qualification qualification);
	
	List<FederatedIdentifier> findByClass(Class theClass);
	
	List<FederatedIdentifier> findByClassScheme(ClassScheme classScheme);
}
