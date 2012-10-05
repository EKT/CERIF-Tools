/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Language;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Holds the multi-lingual description of a measurement entity.
 * 
 */
@Entity
@Table(name="cfMeasDescr", uniqueConstraints=@UniqueConstraint(columnNames={"cfMeasId","cfLangCode","cfTrans"}))
public class MeasurementDescription implements MeasurementTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 5568439806848611932L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The measurement.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfMeasId")
	private Measurement measurement;
	
	/**
	 * The language.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfLangCode")
	private Language language;
	
	/**
	 * The translation.
	 */
	@NotNull
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation;
	
	/**
	 * The measurement description.
	 */
	@Column(name="cfDescr", columnDefinition="TEXT")
	private String description;
	
	
	/**
	 * Default Constructor
	 */
	public MeasurementDescription() {
		
	}
	
	/**
	 * 
	 * @param measurement
	 * @param language
	 * @param translation
	 * @param description
	 */
	public MeasurementDescription(Measurement measurement, Language language,
			Translation translation, String description) {
		this.measurement = measurement;
		this.language = language;
		this.translation = translation;
		this.description = description;
	}

	/**
	 * @return the measurement
	 */
	public Measurement getMeasurement() {
		return measurement;
	}
	
	/**
	 * @param measurement the measurement to set
	 */
	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
