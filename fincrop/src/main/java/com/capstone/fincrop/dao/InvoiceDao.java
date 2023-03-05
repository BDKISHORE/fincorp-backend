package com.capstone.fincrop.dao;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class InvoiceDao {

    private Long id;

    private Long supplierCode;

    private String invoiceNumber;

	private String invoiceDate;

	private Double invoiceAmount;

	private String currency;

	private byte[] invoiceFilePath;

	private Long clientDetails;

	private String invoiceStatus;

	public InvoiceDao(Long id, Long supplierCode, String invoiceNumber, String invoiceDate, Double invoiceAmount, String currency, byte[] invoiceFilePath, Long clientDetails, String invoiceStatus) {
		this.id = id;
		this.supplierCode = supplierCode;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.invoiceAmount = invoiceAmount;
		this.currency = currency;
		this.invoiceFilePath = invoiceFilePath;
		this.clientDetails = clientDetails;
		this.invoiceStatus = invoiceStatus;
	}

	public InvoiceDao() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(Long supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
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

	public Long getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(Long clientDetails) {
		this.clientDetails = clientDetails;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
}
