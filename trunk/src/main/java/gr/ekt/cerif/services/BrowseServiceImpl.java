/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.browse.BrowseBox;
import gr.ekt.cerif.browse.BrowseLine;
import gr.ekt.cerif.browse.BrowseType;
import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class BrowseServiceImpl implements BrowseService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Returns the boxe
	 * @return
	 */
	public List<BrowseBox> getBoxes() {
		final List<BrowseBox> list = new ArrayList<BrowseBox>();
		
		BrowseBox box = getAudienceBox();
		if (box.hasValue()) {
			list.add(box);
		}
		
		box = getCountryBox(); 
		if (box.hasValue()) {
			list.add(box);
		}
		
		box = getSubjectBox();
		if (box.hasValue()) {
			list.add(box);
		}
		
		box = getPublisherBox();
		if (box.hasValue()) {
			list.add(box);
		}
		
		box = getSourceBox();
		if (box.hasValue()) {
			list.add(box);
		}
		
		box = getCreatorBox();
		if (box.hasValue()) {
			list.add(box);
		}
		
		return list;
	}
	
	/**
	 * Returns the box "Country".
	 * @return the box "Country".
	 */
	private BrowseBox getCountryBox() {
		BrowseBox box = new BrowseBox();
		box.setType(BrowseType.COUNTRY);
		box.setTitle("Country");
		List result = entityManager.createNamedQuery("ResultProduct_Country.getProductsByCountry").getResultList();
		if (result != null && result.size() > 0) {
			for (Iterator i = result.iterator(); i.hasNext();) {
				final Object[] values = (Object[]) i.next();
				final Country country = (Country)values[0];
				BrowseLine line = new BrowseLine();
				line.setLabel(country.getUri());
				line.setUri(country.getCode());
				line.setSize((Long)values[1]);
				box.addLine(line);
			}
		}
		return box;
	}
	
	/**
	 * Returns the box "Audience".
	 * @return the box "Audience".
	 */
	private BrowseBox getAudienceBox() {
		return getClassBox(BrowseType.AUDIENCE, "Audience", "ResultProduct_Class.countProductsBySchemeURI", "Audience");
	}
	
	/**
	 * Returns the box "Subject".
	 * @return the box "Subject".
	 */
	private BrowseBox getSubjectBox() {
		return getClassBox(BrowseType.SUBJECT, "Subject", "ResultProduct_Class.countProductsBySchemeURI", "Subject");
	}
	
	/**
	 * Constructs a classification box.
	 * @param type The type.
	 * @param title The title.
	 * @param query The named query.
	 * @param uri The URI.
	 * @return a classification box.
	 */
	private BrowseBox getClassBox(BrowseType type, String title, String query, String uri) {
		BrowseBox box = new BrowseBox();
		box.setType(type);
		box.setTitle(title);
		List result = entityManager.createNamedQuery(query).setParameter("uri", uri).getResultList();
		if (result != null && result.size() > 0) {
			for (Iterator i = result.iterator(); i.hasNext();) {
				final Object[] values = (Object[]) i.next();
				final gr.ekt.cerif.features.semantics.Class myClass = ((gr.ekt.cerif.features.semantics.Class)values[0]);
				BrowseLine line = new BrowseLine();
				final ClassTerm translation = myClass.getTranslation(Language.ENGLISH);
				line.setLabel(translation == null ? myClass.getUri() : translation.getTerm());
				line.setUri(myClass.getUri());
				line.setSize((Long)values[1]);
				box.addLine(line);
			}
		}
		return box;
	}
	
	/**
	 * Returns the box "Publisher".
	 * @return the box "Publisher".
	 */
	private BrowseBox getPublisherBox() {
		return getOrganisationBox(BrowseType.PUBLISHER, "Publisher", "OrganisationUnit_ResultProduct.countProductsBySchemeURI", "Publisher-URI");
	}
	
	/**
	 * Returns the box "Source".
	 * @return the box "Source".
	 */
	private BrowseBox getSourceBox() {
		return getOrganisationBox(BrowseType.SOURCE, "Source", "OrganisationUnit_ResultProduct.countProductsBySchemeURI", "Source-URI");
	}
	
	/**
	 * Returns the box "Creator".
	 * @return the box "Creator".
	 */
	private BrowseBox getCreatorBox() {
		return getOrganisationBox(BrowseType.CREATOR, "Creator", "OrganisationUnit_ResultProduct.countProductsBySchemeURI", "Creator-URI");
	}
	
	
	
	/**
	 * Constructs a box with organisations.
	 * @param type The type.
	 * @param title The title.
	 * @param query The named query.
	 * @param uri The URI.
	 * @return a box with organisations.
	 */
	private BrowseBox getOrganisationBox(BrowseType type, String title, String query, String uri) {
		BrowseBox box = new BrowseBox();
		box.setType(type);
		box.setTitle(title);
		List result = entityManager.createNamedQuery(query).setParameter("uri", uri).getResultList();
		if (result != null && result.size() > 0) {
			for (Iterator i = result.iterator(); i.hasNext();) {
				final Object[] values = (Object[]) i.next();
				final OrganisationUnit organisation = ((OrganisationUnit)values[0]);
				BrowseLine line = new BrowseLine();
//				final OrganisationUnitTranslation translation = organisation.getTranslation(Language.ENGLISH);
//				line.setLabel(translation == null ? organisation.getUri() : translation.getName());
				
				final OrganisationUnitName translation = organisation.getOrganisationUnitNameTranslation(Language.ENGLISH);
				line.setLabel(translation == null ? organisation.getUri() : translation.getName());
				
				line.setUri(organisation.getUri());
				line.setSize((Long)values[1]);
				box.addLine(line);
			}
		}
		return box;
	}

}
