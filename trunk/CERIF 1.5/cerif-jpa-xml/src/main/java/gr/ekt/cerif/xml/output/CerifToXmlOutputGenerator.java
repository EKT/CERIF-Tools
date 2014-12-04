package gr.ekt.cerif.xml.output;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.xml.loader.CerifEscapeTool;
import gr.ekt.cerif.xml.records.base.CerifOrganisationUnitRecord;
import gr.ekt.cerif.xml.records.base.CerifPersonRecord;
import gr.ekt.cerif.xml.records.base.CerifProjectRecord;
import gr.ekt.cerif.xml.records.infrastructure.CerifEquipmentRecord;
import gr.ekt.cerif.xml.records.infrastructure.CerifFacilityRecord;
import gr.ekt.cerif.xml.records.infrastructure.CerifServiceRecord;
import gr.ekt.cerif.xml.records.result.CerifResultPatentRecord;
import gr.ekt.cerif.xml.records.result.CerifResultProductRecord;
import gr.ekt.cerif.xml.records.result.CerifResultPublicationRecord;
import gr.ekt.cerif.xml.records.second.CerifCitationRecord;
import gr.ekt.cerif.xml.records.second.CerifElectronicAddressRecord;
import gr.ekt.cerif.xml.records.second.CerifEventRecord;
import gr.ekt.cerif.xml.records.second.CerifFederatedIdentifierRecord;
import gr.ekt.cerif.xml.records.second.CerifFundingRecord;
import gr.ekt.cerif.xml.records.second.CerifIndicatorRecord;
import gr.ekt.cerif.xml.records.second.CerifMeasurementRecord;
import gr.ekt.cerif.xml.records.second.CerifMediumRecord;
import gr.ekt.cerif.xml.records.second.CerifMetricsRecord;
import gr.ekt.cerif.xml.records.second.CerifPostalAddressRecord;
import gr.ekt.cerif.xml.records.semantics.CerifClassRecord;
import gr.ekt.cerif.xml.records.semantics.CerifClassSchemeRecord;
import gr.ekt.transformationengine.core.OutputGenerator;
import gr.ekt.transformationengine.core.Record;
import gr.ekt.transformationengine.core.RecordSet;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.generic.DateTool;
import org.apache.velocity.tools.generic.EscapeTool;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * @author bonisv
 *
 */
public class CerifToXmlOutputGenerator extends OutputGenerator {
	
	/**
	 * Logging facility.
	 */
	private final Logger logger = Logger.getLogger(CerifToXmlOutputGenerator.class);

	/**
	 * The velocity engine.
	 */
	private VelocityEngine cerifToXmlVelocityEngine;
	
	/**
	 * The template.
	 */
	private String template;
	
	/**
	 * The source database.
	 */
	private String xmlSourceDatabase;
	
	/**
	 * The encoding.
	 */
	private String xmlEncoding = "UTF-8";
	
	/**
	 * Whether to produce the result as a byte array.
	 */
	private boolean useByteArray;
	
	/**
	 * The actual result.
	 */
	private Object result;

	/**
	 * Constructor.
	 */
	public CerifToXmlOutputGenerator() {
		super();
	}

	@Override
	public boolean generateOutput(RecordSet recordSet) {

		if (recordSet == null) {
			return false;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Project> projects = new ArrayList<Project>();
		List<OrganisationUnit> organisations = new ArrayList<OrganisationUnit>();
		List<Person> persons = new ArrayList<Person>();
		List<ElectronicAddress> electronicAddresses = new ArrayList<ElectronicAddress>();
		List<PostalAddress> postalAddresses = new ArrayList<PostalAddress>();
		List<Funding> fundings = new ArrayList<Funding>();
		List<Class> classes = new ArrayList<Class>();
		List<ClassScheme> classesSchemes = new ArrayList<ClassScheme>();
		List<ResultPublication> resultPublications = new ArrayList<ResultPublication>();
		List<Facility> facilities = new ArrayList<Facility>();
		List<ResultProduct> resultProducts = new ArrayList<ResultProduct>();
		List<ResultPatent> resultPatents = new ArrayList<ResultPatent>();
		List<Service> services = new ArrayList<Service>();
		List<Equipment> equipments = new ArrayList<Equipment>();
		List<FederatedIdentifier> federatedIdentifiers = new ArrayList<FederatedIdentifier>();
		List<Measurement> measurements = new ArrayList<Measurement>();
		List<Indicator> indicators = new ArrayList<Indicator>();
		List<Medium> mediums = new ArrayList<Medium>();
		List<Event> events = new ArrayList<Event>();
		List<Metrics> metrics = new ArrayList<Metrics>();
		List<Citation> citations = new ArrayList<Citation>();

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
		    } else if (tmpRecord instanceof CerifResultPatentRecord) {
		    	resultPatents.add(((CerifResultPatentRecord)tmpRecord).getResultPatent());
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
		    } else if (tmpRecord instanceof CerifIndicatorRecord) {
		    	indicators.add(((CerifIndicatorRecord)tmpRecord).getIndicator());
		    } else if (tmpRecord instanceof CerifMediumRecord) {
		    	mediums.add(((CerifMediumRecord)tmpRecord).getMedium());
		    } else if (tmpRecord instanceof CerifEventRecord) {
		    	events.add(((CerifEventRecord)tmpRecord).getEvent());
		    } else if (tmpRecord instanceof CerifEventRecord) {
		    	events.add(((CerifEventRecord)tmpRecord).getEvent());
		    } else if (tmpRecord instanceof CerifCitationRecord) {
		    	citations.add(((CerifCitationRecord)tmpRecord).getCitation());
		    }
		}

		CerifEscapeTool tool = new CerifEscapeTool();
		map.put(tool.getKey(), tool);
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
		map.put("resultPatents", resultPatents);
		map.put("facilities", facilities);
		map.put("services", services);
		map.put("equipments", equipments);
		map.put("federatedIdentifiers", federatedIdentifiers);
		map.put("measurements", measurements);
		map.put("indicators", indicators);
		map.put("mediums", mediums);
		map.put("events", events);
		map.put("metrics", metrics);
		map.put("citations", citations);
		
		map.put("xmlDate", new Date());
		map.put("xmlSourceDatabase", xmlSourceDatabase);
		map.put("xmlEncoding", xmlEncoding);
		
		try {
			if (useByteArray) {
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				OutputStreamWriter writer = new OutputStreamWriter(output, xmlEncoding);
				VelocityEngineUtils.mergeTemplate(cerifToXmlVelocityEngine, template, xmlEncoding, map, writer);
				writer.flush();
				writer.close();
				result = output.toByteArray();
			} else {
				result = VelocityEngineUtils.mergeTemplateIntoString(cerifToXmlVelocityEngine, template, xmlEncoding, map);
			}
		
		} catch (Exception e) {
			logger.error("Could not produce XML from velocity template.", e);
		}
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
	 * Returns the result as a byte array.
	 * @return a byte array.
	 */
	public byte[] getResultAsByteArray() {
		return (byte[]) result;
	}
	
	/**
	 * Returns the result as a string.
	 * @return a string.
	 */
	public String getResultAsString() {
		return (String) result;
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

	/**
	 * Sets the encoding of the produced XML result.
	 * @param xmlEncoding The XML encoding.
	 */
	public void setXmlEncoding(String xmlEncoding) {
		this.xmlEncoding = xmlEncoding;
	}
	
	/**
	 * Returns the encoding of the produced XML result. 
	 * @return the encoding.
	 */
	public String getXmlEncoding() {
		return xmlEncoding;
	}
	
	public void setUseByteArray(boolean useByteArray) {
		this.useByteArray = useByteArray;
	}
	
	
}
