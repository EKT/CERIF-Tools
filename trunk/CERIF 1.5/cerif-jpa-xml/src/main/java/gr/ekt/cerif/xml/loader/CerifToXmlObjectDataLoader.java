package gr.ekt.cerif.xml.loader;

import gr.ekt.cerif.CerifEntity;
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
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.xml.loadingSpecs.ObjectLoadingSpecs;
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
import gr.ekt.transformationengine.core.DataLoader;
import gr.ekt.transformationengine.core.Record;
import gr.ekt.transformationengine.core.RecordSet;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Loader that accepts CERIF entities as input.
 * In contrast to {@link CerifToXmlDataLoader}, this loader requires no connection to a database.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
@Component
public class CerifToXmlObjectDataLoader extends DataLoader {
	
	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.DataLoader#loadData()
	 */
	@Override
	public RecordSet loadData() {
		RecordSet result = new RecordSet();
		
		ObjectLoadingSpecs specs = ((ObjectLoadingSpecs)this.getLoadingSpec());
		
		List<CerifEntity> entities = specs.getEntities();
		
		if (entities == null || entities.isEmpty()) {
			throw new IllegalArgumentException("No entities provided.");
		}
		
		for (CerifEntity entity : entities) {
			Record record = getRecord(entity);
			result.addRecord(record);
		}
		
		return result;
	}
	
	/**
	 * Constructs the appropriate record based on the entity type.
	 * @param entity The CERIF entity.
	 * @return a record.
	 */
	private Record getRecord(CerifEntity entity) {
		Record record;
		if (entity instanceof Project) {
			record = new CerifProjectRecord((Project) entity);
			
		} else if (entity instanceof OrganisationUnit) {
			record = new CerifOrganisationUnitRecord((OrganisationUnit) entity);
			
		} else if (entity instanceof Person) {
			record = new CerifPersonRecord((Person) entity);
			
		} else if (entity instanceof ElectronicAddress) {
			record = new CerifElectronicAddressRecord((ElectronicAddress) entity);
			
		} else if (entity instanceof PostalAddress) {
			record = new CerifPostalAddressRecord((PostalAddress) entity);
			
		} else if (entity instanceof Funding) {
			record = new CerifFundingRecord((Funding) entity);
			
		} else if (entity instanceof gr.ekt.cerif.features.semantics.Class) {
			record = new CerifClassRecord((gr.ekt.cerif.features.semantics.Class) entity);
			
		} else if (entity instanceof ClassScheme) {
			record = new CerifClassSchemeRecord((ClassScheme) entity);
			
		} else if (entity instanceof ResultPublication) {
			record = new CerifResultPublicationRecord((ResultPublication) entity);
			
		} else if (entity instanceof ResultProduct) {
			record = new CerifResultProductRecord((ResultProduct) entity);
			
		} else if (entity instanceof Facility) {
			record = new CerifFacilityRecord((Facility) entity);
			
		} else if (entity instanceof Service) {
			record = new CerifServiceRecord((Service) entity);
			
		} else if (entity instanceof Equipment) {
			record = new CerifEquipmentRecord((Equipment) entity);
			
		} else if (entity instanceof FederatedIdentifier) {
			record = new CerifFederatedIdentifierRecord((FederatedIdentifier) entity);
	
		} else if (entity instanceof FederatedIdentifier) {
			record = new CerifFederatedIdentifierRecord((FederatedIdentifier) entity);
			
		} else if (entity instanceof Measurement) {
			record = new CerifMeasurementRecord((Measurement) entity);
				
		} else {
			throw new IllegalArgumentException(String.format("Invalid entity provided. %s is not yet supported.", entity.getClass().getName()));
		}
		return record;
	}
	
}
