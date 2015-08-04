package gr.ekt.cerif.entities.link;

import java.util.Date;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="cfClassScheme_Class" , uniqueConstraints=@UniqueConstraint(columnNames={"cfRelatedClassSchemeId","cfRelatedClassId","cfClassId", "cfStartDate", "cfEndDate"}))
public class ClassScheme_Class implements ICerifClassEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6046235012753546188L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The class scheme.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfRelatedClassSchemeId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private ClassScheme relatedClassScheme;
		
	/**
	 * The class.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfRelatedClassId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Class relatedClass;
	
	/**
	 * The link's class.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfClassId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@NotNull
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@NotNull
	@Column (name="cfEndDate")
	private Date endDate;

	
	/**
	 * 
	 */
	public ClassScheme_Class() {
		super();
	}
	
	/**
	 * @param relatedClassScheme
	 * @param relatedClass
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 */
	public ClassScheme_Class(ClassScheme relatedClassScheme,
			Class relatedClass, Class theClass, Date startDate, Date endDate) {
		super();
		this.relatedClassScheme = relatedClassScheme;
		this.relatedClass = relatedClass;
		this.theClass = theClass;
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
	 * @return the relatedClassScheme
	 */
	public ClassScheme getRelatedClassScheme() {
		return relatedClassScheme;
	}

	/**
	 * @param relatedClassScheme the relatedClassScheme to set
	 */
	public void setRelatedClassScheme(ClassScheme relatedClassScheme) {
		this.relatedClassScheme = relatedClassScheme;
	}

	/**
	 * @return the relatedClass
	 */
	public Class getRelatedClass() {
		return relatedClass;
	}

	/**
	 * @param relatedClass the relatedClass to set
	 */
	public void setRelatedClass(Class relatedClass) {
		this.relatedClass = relatedClass;
	}

	/**
	 * @return the theClass
	 */
	public Class getTheClass() {
		return theClass;
	}

	/**
	 * @param theClass the theClass to set
	 */
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassScheme_Class [id=" + id + ", relatedClassScheme="
				+ relatedClassScheme + ", relatedClass=" + relatedClass
				+ ", theClass=" + theClass + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	

}
