package gr.ekt.cerif;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.ExpertiseAndSkills_Class;
import gr.ekt.cerif.entities.link.PersonName_Class;
import gr.ekt.cerif.entities.link.PersonName_Person;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ExpertiseAndSkills;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_ExpertiseAndSkills;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.CurriculumVitae;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.enumerations.semantics.ClassEnum;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsDescription;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsKeyword;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.services.PersistenceService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Test suite for persistence.
 * 
 */
@ContextConfiguration("cerif-persistence-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=false)
public class PersistenceTests {

	private static final Logger log = LoggerFactory.getLogger(PersistenceTests.class);
	
	/**
	 * The persistence service.
	 */
	@Autowired
	PersistenceService service;
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	

	
	@Test
	public void testOne() {
		Class c = new Class();
		c.setUuid("uuid");
		service.save(c);
		
		Person p =new Person();
		service.save(p);
		PersonName pn = new PersonName();
		pn.setFamilyNames("familyname");
		service.save(pn);
		PersonName_Person pnp = new PersonName_Person(p, pn, 
				service.getSemanticService().getClassRepository().findByUuid("uuid").get(0), new Date(), new Date());
		service.save(pnp);
		PersonName_Class pnc = new PersonName_Class(pn, 
				service.getSemanticService().getClassRepository().findByUuid("uuid").get(0), new Date(), new Date());
		service.save(pnc);		
	}
	
	@Test
	public void testTwo() {
		List<PersonName_Class> pnc = service.getLinkService().getPersonNameClassRepository().findBytheClass(service.getSemanticService().getClassRepository().findByUuid("uuid").get(0));
		service.delete(pnc);
		
		List<PersonName_Person> pnp = service.getLinkService().getPersonNamePersonRepository().findByPerson(
				service.getBaseService().getPersonRepository().findById((long)2));
		service.delete(pnp);		
	}
	
	@Test
	public void testThree() {
		ClassScheme clsch = service.getSemanticService().getClassSchemeRepository().findById((long)1);
		List<Class> cl1;
		FederatedIdentifier fed;
		for (int i=0; i<15; i++) {
			/*ResultPublication respubl = new ResultPublication();
			respubl.setEdition("sdrgadrgadrgw35d3ct234513f4");
			respubl = service.save(respubl);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.PUBLICATION.getUuid());
			fed = new FederatedIdentifier(respubl.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			OrganisationUnit org = new OrganisationUnit();
			org.setAcronym("acro");
			org = service.save(org);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.ORGANISATION.getUuid());
			fed = new FederatedIdentifier(org.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Class cl = new Class();
			cl.setUri("uri");
			cl = service.save(cl);
			
			Language langEN = Language.ENGLISH;
			langEN = service.save(langEN);
			
			OrganisationUnitName orgn = new OrganisationUnitName(org, langEN, Translation.h, "OrganisationUnitName");
			orgn = service.save(orgn);
			
			OrganisationUnit_ResultPublication orgres = new OrganisationUnit_ResultPublication(org, respubl, cl, new Date(), new Date());
			orgres = service.save(orgres);
			
			Project proj = new Project();
			proj = service.save(proj);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.PROJECT.getUuid());
			fed = new FederatedIdentifier(proj.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Project_ResultPublication projres = new Project_ResultPublication(proj, respubl, cl, new Date(), new Date());
			projres = service.save(projres);
		
			
			Facility fac = new Facility();
			fac = service.save(fac);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.FACILITY.getUuid());
			fed = new FederatedIdentifier(fac.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
						
			Equipment equ = new Equipment();
			equ = service.save(equ);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.EQUIPMENT.getUuid());
			fed = new FederatedIdentifier(equ.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Service srv = new Service();
			srv = service.save(srv);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.SERVICE.getUuid());
			fed = new FederatedIdentifier(srv.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Citation cit = new Citation();
			cit = service.save(cit);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.CITATION.getUuid());
			fed = new FederatedIdentifier(cit.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			ElectronicAddress ele = new ElectronicAddress();
			ele = service.save(ele);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.ELECTRONIC_ADDRESS.getUuid());
			fed = new FederatedIdentifier(ele.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Country coun = new Country();
			coun.setCode("gr");
			coun = service.save(coun);
			
			Event ev = new Event();
			ev.setCountry(coun);
			ev.setFeeOrFree("sdsdcv");
			ev = service.save(ev);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.EVENT.getUuid());
			fed = new FederatedIdentifier(ev.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			ExpertiseAndSkills exp = new ExpertiseAndSkills();
			exp = service.save(exp);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.EXPERTISE_AND_SKILLS.getUuid());
			fed = new FederatedIdentifier(exp.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Funding fun = new Funding();
			fun = service.save(fun);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.FUNDING.getUuid());
			fed = new FederatedIdentifier(fun.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			GeographicBoundingBox geo = new GeographicBoundingBox();
			geo = service.save(geo);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.GEOGRAPHIC_BOUNDING_BOX.getUuid());
			fed = new FederatedIdentifier(geo.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Indicator ind = new Indicator();
			ind = service.save(ind);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.INDICATOR.getUuid());
			fed = new FederatedIdentifier(ind.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Measurement mea = new Measurement();
			mea = service.save(mea);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.MEASUREMENT.getUuid());
			fed = new FederatedIdentifier(mea.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Medium med = new Medium();
			med = service.save(med);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.MEDIUM.getUuid());
			fed = new FederatedIdentifier(med.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Metrics met = new Metrics();
			met = service.save(met);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.METRICS.getUuid());
			fed = new FederatedIdentifier(met.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			PostalAddress pos = new PostalAddress();
			pos.setCountry(coun);
			pos = service.save(pos);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.POSTAL_ADDRESS.getUuid());
			fed = new FederatedIdentifier(pos.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Prize pr = new Prize();
			pr = service.save(pr);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.PRIZE.getUuid());
			fed = new FederatedIdentifier(pr.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Qualification qua = new Qualification();
			qua = service.save(qua);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.QUALIFICATION.getUuid());
			fed = new FederatedIdentifier(qua.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			ResultProduct resprod = new ResultProduct();
			resprod = service.save(resprod);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.PRODUCT.getUuid());
			fed = new FederatedIdentifier(resprod.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			ResultPatent respat= new ResultPatent();
			respat = service.save(respat);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.PATENT.getUuid());
			fed = new FederatedIdentifier(respat.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);*/			
			
			/*CurriculumVitae cv = new CurriculumVitae();
			cv = service.save(cv);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.CURRICULUM_VITAE.getUuid());
			fed = new FederatedIdentifier(cv.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);*/
			
			ExpertiseAndSkills exp = new ExpertiseAndSkills();
			exp = service.save(exp);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.EXPERTISE_AND_SKILLS.getUuid());
			fed = new FederatedIdentifier(exp.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Language langEN = service.getSecondService().getLanguageRepository().findByCode(Language.ENGLISH.getCode());
					
			ExpertiseAndSkillsName exn = new ExpertiseAndSkillsName(exp,
					langEN, Translation.h, "sfhsfhbfbh");
			service.save(exn);
			
			ExpertiseAndSkillsKeyword exk = new ExpertiseAndSkillsKeyword(exp,
					langEN, Translation.h, "sfhsfhbfbh");
			service.save(exk);
			
			ExpertiseAndSkillsDescription exd = new ExpertiseAndSkillsDescription(exp,
					langEN, Translation.h, "sfhsfhbfbh");
			service.save(exd);
			
			OrganisationUnit org = new OrganisationUnit();
			org.setAcronym("acro");
			org = service.save(org);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.ORGANISATION.getUuid());
			fed = new FederatedIdentifier(org.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Person pers = new Person();
			pers = service.save(pers);
			cl1 = service.getSemanticService().getClassRepository().findByUuid(ClassEnum.PERSON.getUuid());
			fed = new FederatedIdentifier(pers.getId(), "asdcasdc", cl1.get(0),
					clsch, new Date(), new Date());
			service.save(fed);
			
			Class cl = new Class();
			cl.setUri("uri");
			cl = service.save(cl);
			
			Person_ExpertiseAndSkills pe = new Person_ExpertiseAndSkills(pers, exp, cl,
					new Date(), new Date());
			service.save(pe);
			
			OrganisationUnit_ExpertiseAndSkills oe = new OrganisationUnit_ExpertiseAndSkills(org, exp, cl,
					new Date(), new Date());
			service.save(oe);
			
			ExpertiseAndSkills_Class oc = new ExpertiseAndSkills_Class(exp, cl,
					new Date(), new Date());
			service.save(oc);			
			
		}
			
	}

	
	@Test
	public void testFour() {
		Language langEN = Language.ENGLISH;
		langEN = service.save(langEN);

		long start = System.currentTimeMillis();
		for (int i=0; i<1500; i++) {
			ResultPublication respubl = new ResultPublication();
			respubl.setEdition("sdrgadrgadrgw35d3ct234513f4");
			respubl = service.save(respubl);
			
			OrganisationUnit org = new OrganisationUnit();
			org.setAcronym("acro");
			org = service.save(org);
			
			Class cl = new Class();
			cl.setUri("uri");
			cl = service.save(cl);
			
			OrganisationUnitName orgn = new OrganisationUnitName(org, langEN, Translation.h, "OrganisationUnitName");
			orgn = service.save(orgn);
			
			OrganisationUnit_ResultPublication orgres = new OrganisationUnit_ResultPublication(org, respubl, cl, new Date(), new Date());
			orgres = service.save(orgres);
		}
		long elapsedTimeMillis = System.currentTimeMillis()-start;
		
		System.out.println("total milliseconds: "+elapsedTimeMillis);
		
	}

	
	@Test
	public void testFive() {
		ArrayList<CerifEntity> ar = new ArrayList<CerifEntity>();
		
		for (int i=0; i<170; i++) {
			/*ResultPublication respubl = service.getResultService().getResultPublicationRepository().findById((long)(32+i));
			if (respubl != null) {
				ar.add(respubl);
			}			
			
			OrganisationUnit org = service.getBaseService().getOrganisationUnitRepository().findById((long)(7+i));
			if (org != null) {
				ar.add(org);
			}
			
			Project proj = service.getBaseService().getProjectRepository().findById((long)(3+i));
			if (proj != null) {
				ar.add(proj);
			}
			
			ResultPatent respat = service.getResultService().getResultPatentRepository().findById((long)(2+i));
			if (respat != null) {
				ar.add(respat);
			}
			
			ResultProduct resprod = service.getResultService().getResultProductRepository().findById((long)(1+i));
			if (resprod != null) {
				ar.add(resprod);
			}
			
			Facility fac = service.getInfrastructureService().getFacilityRepository().findById((long)(1+i));
			if (fac != null) {
				ar.add(fac);
			}
			
			Funding fun = service.getSecondService().getFundingRepository().findById((long)(1+i));
			if (fun != null) {
				ar.add(fun);
			}
			
			Equipment equ = service.getInfrastructureService().getEquipmentRepository().findById((long)(1+i));
			if (equ != null) {
				ar.add(equ);
			}
			
			Service srv = service.getInfrastructureService().getServiceRepository().findById((long)(1+i));
			if (srv != null) {
				ar.add(srv);
			}
			
			Citation cit = service.getSecondService().getCitationRepository().findById((long)(1+i));
			if (cit != null) {
				ar.add(cit);
			}
			
			ElectronicAddress ele = service.getSecondService().getElectronicAddressRepository().findById((long)(1+i));
			if (ele != null) {
				ar.add(ele);
			}
			
			Event ev = service.getSecondService().getEventRepository().findById((long)(1+i));
			if (ev != null) {
				ar.add(ev);
			}
			
			ExpertiseAndSkills exp = service.getSecondService().getExpertiseAndSkillsRepository().findById((long)(1+i));
			if (exp != null) {
				ar.add(exp);
			}
			
			Indicator ind = service.getSecondService().getIndicatorRepository().findById((long)(1+i));
			if (ind != null) {
				ar.add(ind);
			}
			
			GeographicBoundingBox geo = service.getSecondService().getGeographicBoundingBoxRepository().findById((long)(1+i));
			if (geo != null) {
				ar.add(geo);
			}
			
			Measurement mea = service.getSecondService().getMeasurementRepository().findById((long)(1+i));
			if (mea != null) {
				ar.add(mea);
			}
			
			Medium med = service.getSecondService().getMediumRepository().findById((long)(1+i));
			if (med != null) {
				ar.add(med);
			}
			
			Metrics met = service.getSecondService().getMetricsRepository().findById((long)(1+i));
			if (met != null) {
				ar.add(met);
			}
			
			PostalAddress pos = service.getSecondService().getPostalAddressRepository().findById((long)(1+i));
			if (pos != null) {
				ar.add(pos);
			}
			
			Prize pri = service.getSecondService().getPrizeRepository().findById((long)(1+i));
			if (pri != null) {
				ar.add(pri);
			}
			
			Qualification qua = service.getSecondService().getQualificationRepository().findById((long)(1+i));
			if (qua != null) {
				ar.add(qua);
			}
			
			Class cl = service.getSemanticService().getClassRepository().findById((long)(5+i));
			if (cl != null) {
				ar.add(cl);
			}*/
			
			/*CurriculumVitae cv = service.getSecondService().getCurriculumVitaeRepository().findById((long)(1+i));
			if (cv != null) {
				ar.add(cv);
			}*/
			
			ExpertiseAndSkills exp = service.getSecondService().getExpertiseAndSkillsRepository().findById((long)(1+i));
			if (exp != null) {
				ar.add(exp);
			}
		}
		
		service.delete(ar);	
		
	}
	
	
	@Test
	public void testSix() {
		ClassScheme clsch = service.getSemanticService().getClassSchemeRepository().findById((long)1);
		
		Class cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.PUBLICATION.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.PERSON.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.PROJECT.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.ORGANISATION.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.PATENT.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.PRODUCT.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.PUBLICATION.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.FUNDING.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.FACILITY.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.EQUIPMENT.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.SERVICE.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.CITATION.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.CURRICULUM_VITAE.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.ELECTRONIC_ADDRESS.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.POSTAL_ADDRESS.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.EVENT.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.MEDIUM.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.METRICS.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.COUNTRY.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.CURRENCY.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.EXPERTISE_AND_SKILLS.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.LANGUAGE.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.PRIZE.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.GEOGRAPHIC_BOUNDING_BOX.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.QUALIFICATION.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.FEDERATED_IDENTIFIER.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.MEASUREMENT.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.INDICATOR.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.CLASSIFICATION.getUuid());
		cl1 = service.save(cl1);
		
		cl1 = new Class();
		cl1.setScheme(clsch);
		cl1.setUuid(ClassEnum.CLASSIFICATION_SCHEME.getUuid());
		cl1 = service.save(cl1);
	}
	
	@Test
	public void testSeven() {
		OrganisationUnit org = service.getBaseService().getOrganisationUnitRepository().findById((long)1);
		List<OrganisationUnit_OrganisationUnit> orgl = service.getLinkService().getOrganisationUnitOrganisationUnitRepository().findByOrganisationUnit1(org);
		System.out.println(orgl.get(0).getOrganisationUnit1().getId());
		System.out.println(orgl.get(0).getOrganisationUnit2().getId());
		
		orgl = service.getLinkService().getOrganisationUnitOrganisationUnitRepository().findByOrganisationUnit2(org);
		System.out.println(orgl.get(0).getOrganisationUnit1().getId());
		System.out.println(orgl.get(0).getOrganisationUnit2().getId());
	}
	
}
