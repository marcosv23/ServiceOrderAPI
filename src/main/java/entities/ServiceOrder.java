package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import enums.StatusServiceOrder;
import validationgroups.ValidationGroup;

@Entity
@Table(name="service_orders")
public class ServiceOrder implements Serializable{
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private float price;
	
	@NotBlank
	private String description;
	
	@Enumerated(EnumType.STRING)
	@JsonProperty(access=Access.READ_ONLY)
	private StatusServiceOrder status;
	
	
	@NotNull
	@Valid
	@ConvertGroup(from =Default.class, to= ValidationGroup.CustomerId.class)
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy="serviceOrder")
	private List<Comment> comments;
	
	@Column(name="starting_date")
	@JsonProperty(access=Access.READ_ONLY)
	private OffsetDateTime startingDate;
	
	@Column(name="ending_date")
	@JsonProperty(access=Access.READ_ONLY)
	private OffsetDateTime endingDate;
	
	@Column(name="created_at")
	@JsonProperty(access=Access.READ_ONLY)
	private Date createdAt;
	
	@Column(name="updated_at")
	@JsonProperty(access=Access.READ_ONLY)
	private Date updatedAt;
	
	@Column(name="deleted_at")
	@JsonProperty(access=Access.READ_ONLY)
	private Date deletedAt;
	
	
	
	
	public ServiceOrder() {
		super();
	}
	

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public StatusServiceOrder getStatus() {
		return status;
	}



	public void setStatus(StatusServiceOrder status) {
		this.status = status;
	}


	public Integer getId() {
		return id;
	}
     
	public void setId(Integer id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public OffsetDateTime getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(OffsetDateTime startingDate) {
		this.startingDate = startingDate;
	}

	public OffsetDateTime getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(OffsetDateTime endingDate) {
		this.endingDate = endingDate;
	}

	
	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Date getDeletedAt() {
		return deletedAt;
	}



	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceOrder other = (ServiceOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
