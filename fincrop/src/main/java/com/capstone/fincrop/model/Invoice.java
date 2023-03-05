package com.capstone.fincrop.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "supplier_code")
    private SupplierDetails supplierCode;

	@Column(name = "invoiceNumber")
    private String invoiceNumber;

	@Column(name = "invoiceDate")
	private LocalDate invoiceDate;

	@Column(name = "invoiceAmount")
	private Double invoiceAmount;

	@Column(name = "currency")
	private String currency;

	@Lob
	@Column(name = "invoiceFilePath")
	private byte[] invoiceFilePath;

	@Column(name="invoiceStatus")
	private String invoiceStatus;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private ClientDetails clientDetails;

	public Invoice() {
	}

	public Invoice(Long id, SupplierDetails supplierCode, String invoiceNumber, LocalDate invoiceDate, Double invoiceAmount, String currency, byte[] invoiceFilePath, String invoiceStatus, ClientDetails clientDetails) {
		this.id = id;
		this.supplierCode = supplierCode;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.invoiceAmount = invoiceAmount;
		this.currency = currency;
		this.invoiceFilePath = invoiceFilePath;
		this.invoiceStatus = invoiceStatus;
		this.clientDetails = clientDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SupplierDetails getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(SupplierDetails supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public byte[] getInvoiceFilePath() {
		return invoiceFilePath;
	}

	public void setInvoiceFilePath(byte[] invoiceFilePath) {
		this.invoiceFilePath = invoiceFilePath;
	}

	public ClientDetails getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
}
