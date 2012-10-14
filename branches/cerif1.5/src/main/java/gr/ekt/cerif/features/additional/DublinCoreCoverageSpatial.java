/**
 * 
 */
package gr.ekt.cerif.features.additional;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Represents a DublinCoreCoverageSpatial entity.
 * 
 */
@Entity
@Table(name="cfDCCoverageSpatial", uniqueConstraints=@UniqueConstraint(columnNames={"cfDCId","cfDCScheme","cfDCLangTag","cfDCTrans"}))
public class DublinCoreCoverageSpatial implements CerifAdditionalFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 5096302662376204489L;
	
	/**
	 * The citation id.
	 */
	@Id
	@Column(name="cfDCId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The dc scheme.
	 */
	@NotNull
	@Column(name="cfDCScheme")
	private String scheme;
	
	/**
	 * The dc language.
	 */
	@NotNull
	@Column(name="cfDCLangTag")
	private String language;
	
	/**
	 * The dc translation.
	 */
	@NotNull
	@Column(name="cfDCTrans")
	private String translation;
	
	/**
	 * The dc value.
	 */
	@Column(name="cfDCValue")
	private String value;
	
	/**
	 * The dc xCoordinate.
	 */
	@Column(name="cfFDCXCoordinate")
	private String xCoordinate;
	
	/**
	 * The dc yCoordinate.
	 */
	@Column(name="cfFDCYCoordinate")
	private String yCoordinate;
	
	/**
	 * The dc zCoordinate.
	 */
	@Column(name="cfFDCZCoordinate")
	private String zCoordinate;
	
	/**
	 * The dc precision.
	 */
	@Column(name="cfFDCPrecision")
	private Double precision;
		
	/**
	 * Default Constructor
	 */
	public DublinCoreCoverageSpatial() {
		
	}
	
	/**
	 * 
	 * @param scheme
	 * @param language
	 * @param translation
	 * @param value
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param zCoordinate
	 * @param precision
	 */
	public DublinCoreCoverageSpatial(String scheme, String language,
			String translation, String value, String xCoordinate,
			String yCoordinate, String zCoordinate, Double precision) {
		this.scheme = scheme;
		this.language = language;
		this.translation = translation;
		this.value = value;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.zCoordinate = zCoordinate;
		this.precision = precision;
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

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(String xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public String getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(String yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public String getzCoordinate() {
		return zCoordinate;
	}

	public void setzCoordinate(String zCoordinate) {
		this.zCoordinate = zCoordinate;
	}

	public Double getPrecision() {
		return precision;
	}

	public void setPrecision(Double precision) {
		this.precision = precision;
	}

	

	
}
