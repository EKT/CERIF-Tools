/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.result.ResultPublicationRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import org.codehaus.jettison.mapped.MappedXMLOutputFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nkons
 * 
 */
@Component
public class InteroperabilityServiceImpl implements InteroperabilityService {
	private static final Logger log = LoggerFactory.getLogger(InteroperabilityServiceImpl.class);
	
	private static final Namespace orgUnitNs = Namespace.getNamespace("http://www.eurocris.org/Uploads/Web%20pages/CERIF-1.3/XML-SCHEMAS/cfOrgUnit-BASE");
	private static final String orgUnitNsLocation = "http://www.eurocris.org/Uploads/Web%20pages/CERIF-1.3/XML-SCHEMAS/cfOrgUnit-BASE http://www.eurocris.org/Uploads/Web%20pages/CERIF-1.3/XML-SCHEMAS/cfOrgUnit-BASE.xsd";

	private static final Namespace resPublNs = Namespace.getNamespace("http://www.eurocris.org/Uploads/Web%20pages/CERIF-1.3/XML-SCHEMAS/cfResPubl-RES");
	private static final String resPublNsLocation = "http://www.eurocris.org/Uploads/Web%20pages/CERIF-1.3/XML-SCHEMAS/cfResPubl-RES http://www.eurocris.org/Uploads/Web%20pages/CERIF-1.3/XML-SCHEMAS/cfResPubl-RES.xsd";
	
	private static final Namespace xsi = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private OrganisationUnitRepository organisationUnitRepository;

	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	public int consume(String xmlContents) {

		SAXBuilder builder = new SAXBuilder();

		try {
			Document document = (Document) builder.build("src/main/resources/cerif-test-0.1.xml");
			Element rootNode = document.getRootElement();

			Iterator itr = (rootNode.getChildren()).iterator();
			while (itr.hasNext()) {
				Element oneLevelDeep = (Element) itr.next();
				List twoLevelsDeep = oneLevelDeep.getChildren();
				// Do something with these children
			}

		} catch (JDOMException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return 0;
	}

	public int exportXml(CerifEntity component) {
		log.info("Exporting xml");
		if (component == null) {
			throw new IllegalArgumentException("Empty component provided. Export will not proceed.");
		}

		Document doc = null;
		if (component instanceof OrganisationUnit) {
			//OrganisationUnit orgUnit = organisationUnitRepository.findById(new Long(141));
			doc = createOrgUnitXml((OrganisationUnit) component, orgUnitNs);
		} else if (component instanceof ResultPublication) {
			//ResultPublication resPubl = resultPublicationRepository.findById(new Long(59));
			doc = createResPublXml((ResultPublication) component, resPublNs);
		}

		try {
			XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
			String xmlString = out.outputString(doc);
			File f = new File("cfOrgUnit-BASE.xml");
			log.info("Writing file " + f.getAbsolutePath() + " with contents " + xmlString);
			FileOutputStream fOut = new FileOutputStream(f);
			
			out.output(doc.getRootElement(), fOut);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int exportJson(CerifEntity component) {
		log.info("Exporting json");

		if (component == null) {
			throw new IllegalArgumentException("Empty component provided. Export will not proceed.");
		}

		if (component instanceof OrganisationUnit) {
			String json = createJsonFromXml(createOrgUnitXml((OrganisationUnit) component, Namespace.NO_NAMESPACE));
			log.info("json is " + json);
		} else if (component instanceof ResultPublication) {
			String json = createJsonFromXml(createResPublXml((ResultPublication) component, Namespace.NO_NAMESPACE));
			log.info("json is " + json);
		}
		return 0;
	}
	
	private Document createOrgUnitXml(OrganisationUnit orgUnit, Namespace ns) {
		Document doc = new Document();

		Element rootElement = new Element("CERIF");
		rootElement.setAttribute("sourceDatabase", "euroris_net");

		if (ns != null && ns != Namespace.NO_NAMESPACE) {
			rootElement.setNamespace(ns);
			rootElement.setAttribute("schemaLocation", orgUnitNsLocation, xsi);
		}

		rootElement.setAttribute("release", "1.3");
		rootElement.setAttribute("date", dateFormat.format(Calendar.getInstance().getTime()));
		
		Element orgUnitElement = new Element("cfOrgUnit", ns);

		Element orgUnitIdElement = new Element("cfOrgUnitId", ns);
		orgUnitIdElement.addContent(String.valueOf(orgUnit.getId()));

		Element acroElement = new Element("cfAcro", ns);
		acroElement.addContent(orgUnit.getAcronym());

		Element headCountElement = new Element("cfHeadcount", ns);
		headCountElement.addContent(String.valueOf(orgUnit.getHeadCount()));

		Element uriElement = new Element("cfURI", ns);

		uriElement.addContent(orgUnit.getUri());

		orgUnitElement.addContent(orgUnitIdElement);
		orgUnitElement.addContent(acroElement);
		orgUnitElement.addContent(headCountElement);
		orgUnitElement.addContent(uriElement);

		rootElement.addContent(orgUnitElement);
		doc.setContent(rootElement);

		return  doc;
	}
	
	private Document createResPublXml(ResultPublication resPubl, Namespace ns) {
		Document doc = new Document();

		Element rootElement = new Element("CERIF");
		rootElement.setAttribute("sourceDatabase", "euroris_net");

		if (ns != null && ns != Namespace.NO_NAMESPACE) {
			rootElement.setNamespace(ns);
			rootElement.setAttribute("schemaLocation", orgUnitNsLocation, xsi);
		}

		rootElement.setAttribute("release", "1.3");
		rootElement.setAttribute("date", dateFormat.format(Calendar.getInstance().getTime()));
		
		Element resPublElement = new Element("cfResPubl", ns);

		Element resPublIdElement = new Element("cfResPublId", ns);
		resPublIdElement.addContent(String.valueOf(resPubl.getId()));
		
		Element resPublDateElement = new Element("cfResPublDate", ns);
		resPublDateElement.addContent(String.valueOf(resPubl.getDate()));

		Element startPageElement = new Element("cfStartPage", ns);
		startPageElement.addContent(resPubl.getStartPage());

		Element endPageElement = new Element("cfEndPage", ns);
		endPageElement.addContent(resPubl.getEndPage());

		Element totalPagesElement = new Element("cfTotalPages", ns);
		totalPagesElement.addContent(resPubl.getTotalPages());

		Element isbnElement = new Element("cfISBN", ns);
		isbnElement.addContent(resPubl.getIsbn());
		
		Element issnElement = new Element("cfISSN", ns);
		issnElement.addContent(resPubl.getIssn());

		Element uriElement = new Element("cfURI", ns);
		uriElement.addContent(resPubl.getUri());


		resPublElement.addContent(resPublIdElement);
		resPublElement.addContent(resPublDateElement);
		resPublElement.addContent(startPageElement);
		resPublElement.addContent(endPageElement);
		resPublElement.addContent(totalPagesElement);
		resPublElement.addContent(isbnElement);
		resPublElement.addContent(issnElement);
		resPublElement.addContent(uriElement);

		rootElement.addContent(resPublElement);
		doc.setContent(rootElement);

		return  doc;
		
	}
	
	private String createJsonFromXml(Document doc) {
		String json = new String();
		
		try {

			//Document doc = createOrgUnitXml(orgUnit, Namespace.NO_NAMESPACE);
			XMLOutputter out = new XMLOutputter(Format.getCompactFormat());
		
			String xmlStringForJson = out.outputString(doc);

			XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(new StringReader(xmlStringForJson));
			XMLEventWriter writer = new MappedXMLOutputFactory(new HashMap()).createXMLEventWriter(System.out);
			writer.add(reader);
			
			json = writer.toString();
			
			writer.close();
			reader.close();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		}
		return json;
	}

}
