package com.capstone.fincrop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "client_details")
public class ClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String mobilenumber;
    private String loanAccountNumber;
	private Double loanInformation;
	private String state;
	private String city;
	private String country;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user", referencedColumnName = "id")
	private User user;

	public ClientDetails() {
	}

	public ClientDetails(Long id, String name, String address, String email, String mobilenumber, String loanAccountNumber, Double loanInformation, String state, String city, String country, User user) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.loanAccountNumber = loanAccountNumber;
		this.loanInformation = loanInformation;
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

	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	public Double getLoanInformation() {
		return loanInformation;
	}

	public void setLoanInformation(Double loanInformation) {
		this.loanInformation = loanInformation;
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
