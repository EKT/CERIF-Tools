package gr.ekt.cerif.xml.service;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.xml.loadingSpecs.LoadingSpecs;
import gr.ekt.cerif.xml.output.CerifToXmlOutputGenerator;
import gr.ekt.transformationengine.core.TransformationEngine;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Implementation of the CERIF XML service.
 *
 * @author Bill Bonis <bonisv@ekt.gr>
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
@Component
public class XmlCERIFServiceImpl implements XmlCERIFService {

	/**
	 * Logging facility.
	 */
	private Logger logger = Logger.getLogger(XmlCERIFServiceImpl.class);
	
	/**
	 * Transformation engine factory.
	 */
	@Autowired
	private ObjectFactory<TransformationEngine> transformationEngineFactory;
	
	/**
	 * Output generator factory.
	 */
	@Autowired
	private ObjectFactory<CerifToXmlOutputGenerator> cerifToXmlOutputGeneratorFactory;

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.xml.service.XmlCERIFService#makeXMLString(java.util.List)
	 */
	@Override
	public String makeXMLString(List<CerifEntity> entities) {
		return makeXMLString(entities, null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.xml.service.XmlCERIFService#makeXML(java.util.List)
	 */
	@Override
	public byte[] makeXML(List<CerifEntity> entities) {
		return makeXML(entities, null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.xml.service.XmlCERIFService#makeXMLString(java.util.List, gr.ekt.cerif.xml.service.XmlCERIFOptions)
	 */
	@Override
	public String makeXMLString(List<CerifEntity> entities, XmlCERIFOptions options) {

		TransformationEngine cerifToXmlTransformationEngine = transformationEngineFactory.getObject();
		CerifToXmlOutputGenerator cerifToXmlOutputGenerator = cerifToXmlOutputGeneratorFactory.getObject();
		cerifToXmlTransformationEngine.setOutputGenerator(cerifToXmlOutputGenerator);
		
		cerifToXmlOutputGenerator.setUseByteArray(false);
		setParameters(options, cerifToXmlOutputGenerator);
		
		LoadingSpecs specs = getLoadingSpecs(entities);
		cerifToXmlTransformationEngine.getDataLoader().setLoadingSpec(specs);

		try {
			cerifToXmlTransformationEngine.transform();
		} catch (Exception e) {
			logger.error("Error during producing CERIF XML.", e);
		}

		String resultText = cerifToXmlOutputGenerator.getResultAsString();
		
		writeToFile(options, resultText, cerifToXmlOutputGenerator.getXmlEncoding());
		
		return resultText;
	}
	
	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.xml.service.XmlCERIFService#makeXML(java.util.List, gr.ekt.cerif.xml.service.XmlCERIFOptions)
	 */
	@Override
	public byte[] makeXML(List<CerifEntity> entities, XmlCERIFOptions options) {
		
		TransformationEngine cerifToXmlTransformationEngine = transformationEngineFactory.getObject();
		CerifToXmlOutputGenerator cerifToXmlOutputGenerator = cerifToXmlOutputGeneratorFactory.getObject();
		cerifToXmlTransformationEngine.setOutputGenerator(cerifToXmlOutputGenerator);
		
		cerifToXmlOutputGenerator.setUseByteArray(true);
		setParameters(options, cerifToXmlOutputGenerator);
		
		LoadingSpecs specs = getLoadingSpecs(entities);
		cerifToXmlTransformationEngine.getDataLoader().setLoadingSpec(specs);
		
		try {
			cerifToXmlTransformationEngine.transform();
		} catch (Exception e) {
			logger.error("Error during producing CERIF XML.", e);
		}
		
		byte[] result = cerifToXmlOutputGenerator.getResultAsByteArray();
		
		writeToFile(options, result, cerifToXmlOutputGenerator.getXmlEncoding());
		
		return result;
	}

	private void setParameters(XmlCERIFOptions options, CerifToXmlOutputGenerator cerifToXmlOutputGenerator) {
		if (options != null) {
			cerifToXmlOutputGenerator.setXmlSourceDatabase(options.getSourceDatabase());
			
			if (StringUtils.hasText(options.getEncoding())) {
				cerifToXmlOutputGenerator.setXmlEncoding(options.getEncoding());
			}
		}
	}

	/**
	 * Writes the result CERIF XML to a file, if the provided options specify an output file path.
	 * @param options The options.
	 * @param resultText The CERIF XML.
	 */
	private void writeToFile(XmlCERIFOptions options, String content, String encoding) {
		if (options != null && StringUtils.hasText(options.getOutputFilePath())) {
			try {
				FileUtils.write(new File(options.getOutputFilePath()), content, options.getEncoding());
			} catch (Exception e) {
				logger.error(String.format("Error during saving CERIF XML to path [%s].", options.getOutputFilePath()), e);
			}
		}
	}
	
	/**
	 * Writes the result CERIF XML to a file, if the provided options specify an output file path.
	 * @param options The options.
	 * @param resultText The CERIF XML.
	 */
	private void writeToFile(XmlCERIFOptions options, byte[] content, String encoding) {
		if (options != null && StringUtils.hasText(options.getOutputFilePath())) {
			try {
				FileUtils.writeByteArrayToFile(new File(options.getOutputFilePath()), content);
			} catch (Exception e) {
				logger.error(String.format("Error during saving CERIF XML to path [%s].", options.getOutputFilePath()), e);
			}
		}
	}
	
	/**
	 * Creates the loading specifications.
	 * @param entities The entities.
	 * @return a specifications object.
	 */
	private LoadingSpecs getLoadingSpecs(List<CerifEntity> entities) {
		LoadingSpecs specs = new LoadingSpecs();
		specs.setEntities(entities);
		return specs;
	}

}
