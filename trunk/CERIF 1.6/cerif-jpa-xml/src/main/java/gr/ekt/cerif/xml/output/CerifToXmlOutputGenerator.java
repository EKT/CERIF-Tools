package gr.ekt.cerif.xml.output;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.xml.loader.CerifEscapeTool;
import gr.ekt.cerif.xml.records.CerifRecord;
import gr.ekt.cerif.xml.service.SupportedEntities;
import gr.ekt.transformationengine.core.OutputGenerator;
import gr.ekt.transformationengine.core.Record;
import gr.ekt.transformationengine.core.RecordSet;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	 * Whether to include the default XML declaration.
	 */
	private boolean includeDeclaration = true;
	
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
		
		CerifEscapeTool tool = new CerifEscapeTool();
		map.put(tool.getKey(), tool);
		map.put("esc", new EscapeTool());
		map.put("date", new DateTool());
		
		Map<String, List<CerifEntity>> data = prepareData(recordSet.getRecords());
		for (Entry<String, List<CerifEntity>> entry : data.entrySet()) {
			map.put(entry.getKey(), entry.getValue());
		}
		
		map.put("xmlDate", new Date());
		map.put("xmlSourceDatabase", xmlSourceDatabase);
		map.put("xmlEncoding", xmlEncoding);
		map.put("includeDeclaration", includeDeclaration);
		
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
	
	@SuppressWarnings("unchecked")
	private Map<String, List<CerifEntity>> prepareData(List<Record> list) {
		Map<String, List<CerifEntity>> map = new LinkedHashMap<String, List<CerifEntity>>();
		
		for (Record record : list) {
			CerifRecord<CerifEntity> cerifRecord = (CerifRecord<CerifEntity>)record;
			CerifEntity entity = cerifRecord.getEntity();
			String label = SupportedEntities.getLabel(entity.getClass());
			if (!map.containsKey(label)) {
				map.put(label, new ArrayList<CerifEntity>());
			}
			map.get(label).add(entity);
		}
				
		return map;
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
	
	public void setIncludeDeclaration(boolean includeDeclaration) {
		this.includeDeclaration = includeDeclaration;
	}
	
	
}
