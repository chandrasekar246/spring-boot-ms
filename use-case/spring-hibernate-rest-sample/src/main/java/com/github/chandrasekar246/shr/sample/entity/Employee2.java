package com.github.chandrasekar246.shr.sample.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.chandrasekar246.shr.sample.listener.AuditTrailListener;
import com.github.chandrasekar246.shr.sample.model.Department;
import com.github.chandrasekar246.shr.sample.model.PersonName;
import com.github.chandrasekar246.shr.sample.util.PersonNameConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "EnhancedEmployee")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "employee2", uniqueConstraints = { @UniqueConstraint(columnNames = { "id", "pan_number" }) })
@EntityListeners(AuditTrailListener.class)
public class Employee2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Convert(converter = PersonNameConverter.class)
	private PersonName fullName;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthDate;

	@Transient
	private Integer age;

	@NotNull
	@Column(name = "email", length = 50, unique = true, updatable = false)
	@Email
	private String email;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Department department;

	@NotNull
	@Column(columnDefinition = "boolean default false")
	private Boolean married;

	@Basic(optional = true, fetch = FetchType.LAZY)
	private Double salary;
	
	@Embedded
	@AttributeOverride(name = "pan", column = @Column(name = "pan_number"))
	@AttributeOverride(name = "passport", column = @Column(name = "passport_number"))
	private OVD ovd;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	@PostPersist
	public void postPersistCallBack() {
		System.out.println("Added employee with Name: " + fullName + " with ID: " + id);
	}
}
