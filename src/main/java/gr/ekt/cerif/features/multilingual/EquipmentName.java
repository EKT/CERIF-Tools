/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.EquipmentTranslationId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Holds the multi-lingual name of a equipment entity.
 * 
 */
@Entity
@Table(name="cfEquipName")
@IdClass(EquipmentTranslationId.class)
public class EquipmentName implements EquipmentTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 2986337327316317366L;

	/**
	 * The equipment.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfEquipId")
	private Equipment equipment;
	
	/**
	 * The language.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfLangCode")
	private Language language;
	
	/**
	 * The translation.
	 */
	@Id
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation;
	
	/**
	 * The equipment name.
	 */
	@Column(name="cfName")
	private String name;
	
	/**
	 * @return the equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}
	
	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}


	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}


	/**
	 * @return the translation
	 */
	public Translation getTranslation() {
		return translation;
	}


	/**
	 * @param translation the translation to set
	 */
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
