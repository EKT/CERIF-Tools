/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author nhoussos
 * @author karaiskos
 * @author bonisv
 * 
 */
@Entity
@Table(name="cfFedId")
public class FederatedIdentifier implements CerifSecondLevelEntity {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3294630150204664144L;

	/**
	 * The federated identifier database-internal unique id.
	 */
	@Id
	@Column(name="cfFedIdId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The instance id of the CERIF entity identified by the federated identifier (e.g. cfPersonId, cfProjId, cfOrgUnitId).
	 */
	@NotNull
	@Column(name="cfInstId")
	private Long instanceId;
	
	/**
	 * The federated identifier value.
	 */
	@NotNull
	@Column(name="cfFedId")
	private String fedId;
	
	/**
	 * The start date.
	 */
	@Column(name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Column(name="cfEndDate")
	private Date endDate;
	
	/**
	 * The class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")
	private Class theClass;
	
	/**
	 * The classification scheme.
	 */
	@ManyToOne(optional=false)
	@JoinColumn (name = "cfClassSchemeId")
	private ClassScheme scheme;
	
	/**
	 * The UUID.
	 */
	@Column(name="cfUUID")
	private String uuid;

	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="federatedIdentifier")
	private Set<FederatedIdentifier_Class> federatedIdentifiers_classes;	
	
	@OneToMany(mappedBy="federatedIdentifier")
	private Set<Service_FederatedIdentifier> services_federatedIdentifiers;
	
	
	
	/**
	 * 
	 */
	public FederatedIdentifier() {
		super();
	}

	/**
	 * @param instanceId
	 * @param fedId
	 * @param startDate
	 * @param endDate
	 */
	public FederatedIdentifier(Long instanceId, String fedId,
			Date startDate, Date endDate) {
		super();
		this.instanceId = instanceId;
		this.fedId = fedId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * @param instanceId
	 * @param fedId
	 * @param theClass
	 * @param scheme
	 * @param startDate
	 * @param endDate
	 */
	public FederatedIdentifier(Long instanceId, String fedId, Class theClass,
			ClassScheme scheme, Date startDate, Date endDate) {
		this.instanceId = instanceId;
		this.fedId = fedId;
		this.theClass = theClass;
		this.scheme = scheme;
		this.startDate = startDate;
		this.endDate = endDate;
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

	/**
	 * @return the instanceId
	 */
	public Long getInstanceId() {
		return instanceId;
	}

	/**
	 * @param instanceId the instanceId to set
	 */
	public void setInstanceId(Long instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * @return the fedId
	 */
	public String getFedId() {
		return fedId;
	}

	/**
	 * @param fedId the fedId to set
	 */
	public void setFedId(String fedId) {
		this.fedId = fedId;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the federatedIdentifiers_classes
	 */
	public Set<FederatedIdentifier_Class> getFederatedIdentifiers_classes() {
		return federatedIdentifiers_classes;
	}

	/**
	 * @param federatedIdentifiers_classes the federatedIdentifiers_classes to set
	 */
	public void setFederatedIdentifiers_classes(
			Set<FederatedIdentifier_Class> federatedIdentifiers_classes) {
		this.federatedIdentifiers_classes = federatedIdentifiers_classes;
	}

	/**
	 * @return the services_federatedIdentifiers
	 */
	public Set<Service_FederatedIdentifier> getServices_federatedIdentifiers() {
		return services_federatedIdentifiers;
	}

	/**
	 * @param services_federatedIdentifiers the services_federatedIdentifiers to set
	 */
	public void setServices_federatedIdentifiers(
			Set<Service_FederatedIdentifier> services_federatedIdentifiers) {
		this.services_federatedIdentifiers = services_federatedIdentifiers;
	}

	public Class getTheClass() {
		return theClass;
	}

	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}

	public ClassScheme getScheme() {
		return scheme;
	}

	public void setScheme(ClassScheme scheme) {
		this.scheme = scheme;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FederatedIdentifier other = (FederatedIdentifier) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FederatedIdentifier [id=" + id + ", instanceId=" + instanceId
				+ ", fedId=" + fedId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", theClass=" + theClass
				+ ", scheme=" + scheme + ", uuid=" + uuid + "]";
	}

}
