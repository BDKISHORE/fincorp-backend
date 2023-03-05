package com.capstone.fincrop.model;

import javax.persistence.*;


@Entity
@Table(name = "supplier_details")
public class SupplierDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String name;
	private String address;
	private String email;
	private String mobilenumber;
	private String creditAccountNumber;
	private String creditInformation;
	private String state;
	private String city;
	private String country;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user", referencedColumnName = "id")
	private User user;

	public SupplierDetails() {
	}

	public SupplierDetails(Long id, String name, String address, String email, String mobilenumber, String creditAccountNumber, String creditInformation, String state, String city, String country, User user) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.creditAccountNumber = creditAccountNumber;
		this.creditInformation = creditInformation;
		this.state = state;
		this.city = city;
		this.country = country;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getCreditAccountNumber() {
		return creditAccountNumber;
	}

	public void setCreditAccountNumber(String creditAccountNumber) {
		this.creditAccountNumber = creditAccountNumber;
	}

	public String getCreditInformation() {
		return creditInformation;
	}

	public void setCreditInformation(String creditInformation) {
		this.creditInformation = creditInformation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}