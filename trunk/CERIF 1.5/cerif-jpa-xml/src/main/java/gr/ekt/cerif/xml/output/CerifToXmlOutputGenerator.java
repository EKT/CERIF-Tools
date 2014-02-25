package gr.ekt.cerif.xml.output;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.PersistenceService;
import gr.ekt.transformationengine.core.OutputGenerator;
import gr.ekt.transformationengine.core.Record;
import gr.ekt.transformationengine.core.RecordSet;
import gr.ekt.cerif.xml.records.CerifClassRecord;
import gr.ekt.cerif.xml.records.CerifFacilityRecord;
import gr.ekt.cerif.xml.records.CerifFundingRecord;
import gr.ekt.cerif.xml.records.CerifOrganisationUnitRecord;
import gr.ekt.cerif.xml.records.CerifPersonRecord;
import gr.ekt.cerif.xml.records.CerifPostalAddressRecord;
import gr.ekt.cerif.xml.records.CerifProjectRecord;
import gr.ekt.cerif.xml.records.CerifResultProductRecord;
import gr.ekt.cerif.xml.records.CerifResultPublicationRecord;
import gr.ekt.cerif.xml.records.CerifServiceRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.generic.DateTool;
import org.apache.velocity.tools.generic.EscapeTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.apache.commons.io.FileUtils;
/**
 * @author bonisv
 *
 */
public class CerifToXmlOutputGenerator extends OutputGenerator {

	private VelocityEngine cerifToXmlVelocityEngine;
	private String outputDir;
	private String outputFileName;
	private String template;

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
		ArrayList<PostalAddress> postalAddresses = new ArrayList<PostalAddress>();
		ArrayList<Funding> fundings = new ArrayList<Funding>();
		ArrayList<Class> classes = new ArrayList<Class>();
		ArrayList<ResultPublication> resultPublications = new ArrayList<ResultPublication>();
		ArrayList<Facility> facilities = new ArrayList<Facility>();
		ArrayList<ResultProduct> resultProducts = new ArrayList<ResultProduct>();
		ArrayList<Service> services = new ArrayList<Service>();

		Iterator<Record> it = recordSet.getRecords().iterator();
		while (it.hasNext()) {
			Record tmpRecord = it.next();
		    if (tmpRecord instanceof CerifProjectRecord) {
		    	projects.add(((CerifProjectRecord)tmpRecord).getProject());
		    } else if (tmpRecord instanceof CerifOrganisationUnitRecord) {
		    	organisations.add(((CerifOrganisationUnitRecord)tmpRecord).getOrganisationUnit());
		    } else if (tmpRecord instanceof CerifPersonRecord) {
		    	persons.add(((CerifPersonRecord)tmpRecord).getPerson());
		    } else if (tmpRecord instanceof CerifPostalAddressRecord) {
		    	postalAddresses.add(((CerifPostalAddressRecord)tmpRecord).getPostalAddress());
		    } else if (tmpRecord instanceof CerifFundingRecord) {
		    	fundings.add(((CerifFundingRecord)tmpRecord).getFunding());
		    } else if (tmpRecord instanceof CerifClassRecord) {
		    	classes.add(((CerifClassRecord)tmpRecord).getTheClass());
		    } else if (tmpRecord instanceof CerifResultPublicationRecord) {
		    	resultPublications.add(((CerifResultPublicationRecord)tmpRecord).getResultPublication());
		    } else if (tmpRecord instanceof CerifResultProductRecord) {
		    	resultProducts.add(((CerifResultProductRecord)tmpRecord).getResultProduct());
		    } else if (tmpRecord instanceof CerifFacilityRecord) {
		    	facilities.add(((CerifFacilityRecord)tmpRecord).getFacility());
		    } else if (tmpRecord instanceof CerifServiceRecord) {
		    	services.add(((CerifServiceRecord)tmpRecord).getService());
		    }
		}
		
		map.put("esc", new EscapeTool());
		map.put("date", new DateTool());
		
		map.put("projects", projects);
		map.put("organisations", organisations);
		map.put("persons", persons);
		map.put("postalAddresses", postalAddresses);
		map.put("fundings", fundings);
		map.put("classes", classes);
		map.put("resultPublications", resultPublications);
		map.put("resultProducts", resultProducts);
		map.put("facilities", facilities);
		map.put("services", services);
		
		try {
			File file_out = new File(outputDir+outputFileName);
			@SuppressWarnings("deprecation")
			String text = VelocityEngineUtils.mergeTemplateIntoString(cerifToXmlVelocityEngine, template, map);
			
			FileUtils.writeStringToFile(file_out, text);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
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
	 * @return the outputDir
	 */
	public String getOutputDir() {
		return outputDir;
	}

	/**
	 * @param outputDir the outputDir to set
	 */
	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
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
	 * @return the outputFileName
	 */
	public String getOutputFileName() {
		return outputFileName;
	}

	/**
	 * @param outputFileName the outputFileName to set
	 */
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
}
