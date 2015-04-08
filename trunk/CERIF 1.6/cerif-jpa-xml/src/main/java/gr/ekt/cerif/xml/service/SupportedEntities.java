package gr.ekt.cerif.xml.service;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.CurriculumVitae;
import gr.ekt.cerif.entities.second.Citation;
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
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.LinkedHashMap;
import java.util.Map;

public final class SupportedEntities {
	
	/**
	 * The entities.
	 */
	private static final Map<java.lang.Class<? extends CerifEntity>, String> entities;
	
	/**
	 * Private constructor.
	 */
	private SupportedEntities() {
		// nothing to implement here
	}
	
	/**
	 * Initialization.
	 */
	static {
		entities = new LinkedHashMap<java.lang.Class<? extends CerifEntity>, String>();
		entities.put(Project.class, "projects");
		entities.put(OrganisationUnit.class, "organisations");
		entities.put(Person.class, "persons");
		entities.put(ElectronicAddress.class, "electronicAddresses");
		entities.put(PostalAddress.class, "postalAddresses");
		entities.put(Funding.class, "fundings");
		entities.put(Class.class, "classes");
		entities.put(ClassScheme.class, "classesSchemes");
		entities.put(ResultPublication.class, "resultPublications");
		entities.put(ResultProduct.class, "resultProducts");
		entities.put(ResultPatent.class, "resultPatents");
		entities.put(Facility.class, "facilities");
		entities.put(Service.class, "services");
		entities.put(Equipment.class, "equipments");
		entities.put(FederatedIdentifier.class, "federatedIdentifiers");
		entities.put(Measurement.class, "measurements");
		entities.put(Indicator.class, "indicators");
		entities.put(Medium.class, "mediums");
		entities.put(Event.class, "events");
		entities.put(Metrics.class, "metrics");
		entities.put(Citation.class, "citations");
		entities.put(CurriculumVitae.class, "curriculaVitae");
		entities.put(Qualification.class, "qualifications");
		entities.put(Prize.class, "prizes");
		entities.put(GeographicBoundingBox.class, "geographicBoundingBoxes");
		entities.put(ExpertiseAndSkills.class, "expertiseAndSkills");
		entities.put(Country.class, "countries");
		entities.put(Language.class, "languages");
		entities.put(Currency.class, "currencies");
	}
	
	/**
	 * Checks whether an entity is supported.
	 * @param type The entity type.
	 * @return false/true
	 */
	public static boolean isEntitySupported(java.lang.Class<? extends CerifEntity> type) {
		return entities.containsKey(type);
	}
	
	/**
	 * Returns the label of the provided entity type.
	 * @param type The entity type.
	 * @return a string.
	 */
	public static String getLabel(java.lang.Class<? extends CerifEntity> type) {
		return entities.get(type);
	}
	
}
