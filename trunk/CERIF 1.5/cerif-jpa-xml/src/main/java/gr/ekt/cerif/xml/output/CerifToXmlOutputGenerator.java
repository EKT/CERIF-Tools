package gr.ekt.cerif.xml.output;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.services.PersistenceService;
import gr.ekt.transformationengine.core.OutputGenerator;
import gr.ekt.transformationengine.core.Record;
import gr.ekt.transformationengine.core.RecordSet;
import gr.ekt.cerif.xml.records.base.CerifOrganisationUnitRecord;
import gr.ekt.cerif.xml.records.base.CerifPersonRecord;
import gr.ekt.cerif.xml.records.base.CerifProjectRecord;
import gr.ekt.cerif.xml.records.infrastructure.CerifEquipmentRecord;
import gr.ekt.cerif.xml.records.infrastructure.CerifFacilityRecord;
import gr.ekt.cerif.xml.records.infrastructure.CerifServiceRecord;
import gr.ekt.cerif.xml.records.result.CerifResultProductRecord;
import gr.ekt.cerif.xml.records.result.CerifResultPublicationRecord;
import gr.ekt.cerif.xml.records.second.CerifElectronicAddressRecord;
import gr.ekt.cerif.xml.records.second.CerifFederatedIdentifierRecord;
import gr.ekt.cerif.xml.records.second.CerifFundingRecord;
import gr.ekt.cerif.xml.records.second.CerifMeasurementRecord;
import gr.ekt.cerif.xml.records.second.CerifPostalAddressRecord;
import gr.ekt.cerif.xml.records.semantics.CerifClassRecord;
import gr.ekt.cerif.xml.records.semantics.CerifClassSchemeRecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.generic.DateTool;
import org.apache.velocity.tools.generic.EscapeTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * @author bonisv
 *
 */
public class CerifToXmlOutputGenerator extends OutputGenerator {

	private VelocityEngine cerifToXmlVelocityEngine;
	private String template;
	private String xmlSourceDatabase;
	
	private String resultText;

	@Autowired
	PersistenceService service;

	public CerifToXmlOutputGenerator() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean generateOutput(RecordSet recordSet) {

		if (recordSet == null) {
			return false;
		}

		Map map = new HashMap();
		
		ArrayList<Project> projects = new ArrayList<Project>();
		ArrayList<OrganisationUnit> organisations = new ArrayList<OrganisationUnit>();
		ArrayList<Person> persons = new ArrayList<Person>();
		ArrayList<ElectronicAddress> electronicAddresses = new ArrayList<ElectronicAddress>();
		ArrayList<PostalAddress> postalAddresses = new ArrayList<PostalAddress>();
		ArrayList<Funding> fundings = new ArrayList<Funding>();
		ArrayList<Class> classes = new ArrayList<Class>();
		ArrayList<ClassScheme> classesSchemes = new ArrayList<ClassScheme>();
		ArrayList<ResultPublication> resultPublications = new ArrayList<ResultPublication>();
		ArrayList<Facility> facilities = new ArrayList<Facility>();
		ArrayList<ResultProduct> resultProducts = new ArrayList<ResultProduct>();
		ArrayList<Service> services = new ArrayList<Service>();
		ArrayList<Equipment> equipments = new ArrayList<Equipment>();
		ArrayList<FederatedIdentifier> federatedIdentifiers = new ArrayList<FederatedIdentifier>();
		ArrayList<Measurement> measurements = new ArrayList<Measurement>();

		Iterator<Record> it = recordSet.getRecords().iterator();
		while (it.hasNext()) {
			Record tmpRecord = it.next();
		    if (tmpRecord instanceof CerifProjectRecord) {
		    	projects.add(((CerifProjectRecord)tmpRecord).getProject());
		    } else if (tmpRecord instanceof CerifOrganisationUnitRecord) {
		    	organisations.add(((CerifOrganisationUnitRecord)tmpRecord).getOrganisationUnit());
		    } else if (tmpRecord instanceof CerifPersonRecord) {
		    	persons.add(((CerifPersonRecord)tmpRecord).getPerson());
		    } else if (tmpRecord instanceof CerifElectronicAddressRecord) {
		    	electronicAddresses.add(((CerifElectronicAddressRecord)tmpRecord).getElectronicAddress());
		    } else if (tmpRecord instanceof CerifPostalAddressRecord) {
		    	postalAddresses.add(((CerifPostalAddressRecord)tmpRecord).getPostalAddress());
		    } else if (tmpRecord instanceof CerifFundingRecord) {
		    	fundings.add(((CerifFundingRecord)tmpRecord).getFunding());
		    } else if (tmpRecord instanceof CerifClassRecord) {
		    	classes.add(((CerifClassRecord)tmpRecord).getTheClass());
		    } else if (tmpRecord instanceof CerifClassSchemeRecord) {
		    	classesSchemes.add(((CerifClassSchemeRecord)tmpRecord).getClassScheme());
		    } else if (tmpRecord instanceof CerifResultPublicationRecord) {
		    	resultPublications.add(((CerifResultPublicationRecord)tmpRecord).getResultPublication());
		    } else if (tmpRecord instanceof CerifResultProductRecord) {
		    	resultProducts.add(((CerifResultProductRecord)tmpRecord).getResultProduct());
		    } else if (tmpRecord instanceof CerifFacilityRecord) {
		    	facilities.add(((CerifFacilityRecord)tmpRecord).getFacility());
		    } else if (tmpRecord instanceof CerifServiceRecord) {
		    	services.add(((CerifServiceRecord)tmpRecord).getService());
		    } else if (tmpRecord instanceof CerifEquipmentRecord) {
		    	equipments.add(((CerifEquipmentRecord)tmpRecord).getEquipment());
		    } else if (tmpRecord instanceof CerifFederatedIdentifierRecord) {
		    	federatedIdentifiers.add(((CerifFederatedIdentifierRecord)tmpRecord).getFederatedIdentifier());
		    } else if (tmpRecord instanceof CerifMeasurementRecord) {
		    	measurements.add(((CerifMeasurementRecord)tmpRecord).getMeasurement());
		    }
		}

		map.put("esc", new EscapeTool());
		map.put("date", new DateTool());
		
		map.put("projects", projects);
		map.put("organisations", organisations);
		map.put("persons", persons);
		map.put("electronicAddresses", electronicAddresses);
		map.put("postalAddresses", postalAddresses);
		map.put("fundings", fundings);
		map.put("classes", classes);
		map.put("classesSchemes", classesSchemes);
		map.put("resultPublications", resultPublications);
		map.put("resultProducts", resultProducts);
		map.put("facilities", facilities);
		map.put("services", services);
		map.put("equipments", equipments);
		map.put("federatedIdentifiers", federatedIdentifiers);
		map.put("measurements", measurements);
		
		map.put("xmlDate", new Date());
		map.put("xmlSourceDatabase", xmlSourceDatabase);
		
		@SuppressWarnings("deprecation")
		String text = VelocityEngineUtils.mergeTemplateIntoString(cerifToXmlVelocityEngine, template, map);

		resultText = text;

		return true;
	}

	public VelocityEngine getVelocityEngine() {
		return cerifToXmlVelocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.cerifToXmlVelocityEngine = velocityEngine;
	}

	/**
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param template the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * @return the resultText
	 */
	public String getResultText() {
		return resultText;
	}

	/**
	 * @param resultText the resultText to set
	 */
	public void setResultText(String resultText) {
		this.resultText = resultText;
	}

	/**
	 * @return the xmlSourceDatabase
	 */
	public String getXmlSourceDatabase() {
		return xmlSourceDatabase;
	}

	/**
	 * @param xmlSourceDatabase the xmlSourceDatabase to set
	 */
	public void setXmlSourceDatabase(String xmlSourceDatabase) {
		this.xmlSourceDatabase = xmlSourceDatabase;
	}
	
	
}
