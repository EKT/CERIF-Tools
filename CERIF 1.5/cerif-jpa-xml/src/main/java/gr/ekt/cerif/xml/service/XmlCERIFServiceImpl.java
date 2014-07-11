package gr.ekt.cerif.xml.service;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.xml.loadingSpecs.LoadingSpecs;
import gr.ekt.cerif.xml.output.CerifToXmlOutputGenerator;
import gr.ekt.transformationengine.core.TransformationEngine;
import gr.ekt.transformationengine.exceptions.UnimplementedAbstractMethod;
import gr.ekt.transformationengine.exceptions.UnknownClassifierException;
import gr.ekt.transformationengine.exceptions.UnknownInputFileType;
import gr.ekt.transformationengine.exceptions.UnsupportedComparatorMode;
import gr.ekt.transformationengine.exceptions.UnsupportedCriterion;

@Component
public class XmlCERIFServiceImpl implements XmlCERIFService {

	@Autowired
	private ObjectFactory<TransformationEngine> transformationEngineFactory;
	
	@Autowired
	private ObjectFactory<CerifToXmlOutputGenerator> cerifToXmlOutputGeneratorFactory;
	
	@Override
	public String makeXML(LoadingSpecs spec) {

		TransformationEngine cerifToXmlTransformationEngine = transformationEngineFactory.getObject();
		CerifToXmlOutputGenerator cerifToXmlOutputGenerator = cerifToXmlOutputGeneratorFactory.getObject();
		cerifToXmlTransformationEngine.setOutputGenerator(cerifToXmlOutputGenerator);

		//System.out.println("cerifToXmlTransformationEngine: "+cerifToXmlTransformationEngine);
		
		//LoadingSpecs ls = (LoadingSpecs)cerifToXmlTransformationEngine.getDataLoader().getLoadingSpec();
		
		cerifToXmlTransformationEngine.getDataLoader().setLoadingSpec(spec);
		
		/*if (spec.getListOfEntitiesIncluded() != null) {
			ls.setListOfEntitiesIncluded(spec.getListOfEntitiesIncluded());
		} 
		
		if (exclude != null) {
			ls.setListOfEntitiesExcluded(exclude);
		} 
		
		if (windowOffset!=null) {
			ls.setWindowOffset(windowOffset);
		} 
		
		if (windowSize!=null) {
			ls.setWindowSize(windowSize);
		} 
		
		if (links!=null) {
			if (links.equalsIgnoreCase("true")) {
				ls.setLinks(true);
			} else {
				ls.setLinks(false);
			}
		} 
		
		if (showFedIds!=null) {
			if (showFedIds.equalsIgnoreCase("true")) {
				ls.setShowFedIds(true);
			} else {
				ls.setShowFedIds(false);
			}
		} */

		try {
			cerifToXmlTransformationEngine.transform();
		} catch (UnknownClassifierException e) {
			e.printStackTrace();
		} catch (UnknownInputFileType e) {
			e.printStackTrace();
		} catch (UnimplementedAbstractMethod e) {
			e.printStackTrace();
		} catch (UnsupportedComparatorMode e) {
			e.printStackTrace();
		} catch (UnsupportedCriterion e) {
			e.printStackTrace();
		}

		String resultText = cerifToXmlOutputGenerator.getResultText();
		
		return resultText;
	}

}
