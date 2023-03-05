package com.capstone.fincrop.dao;

import com.capstone.fincrop.model.ClientDetails;
import com.capstone.fincrop.model.Invoice;
import com.capstone.fincrop.model.SupplierDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    @Mapping(target = "supplierCode", source = "supplierCode", qualifiedByName = "supplier-conversion")
    @Mapping(target = "clientDetails", source = "clientDetails", qualifiedByName = "client-conversion")
    @Mapping(target= "invoiceFilePath", source = "invoiceFilePath", ignore = true)
    @Mapping(target= "invoiceStatus", source = "invoiceStatus", ignore = false)
    InvoiceDao invoiceToInvoiceDao(Invoice invoice);

    @Mapping(target = "supplierCode", ignore = true)
    @Mapping(target = "clientDetails", ignore = true)
    @Mapping(target = "invoiceDate", source = "invoiceDate", qualifiedByName = "date-conversion")
//    @Mapping(target = "invoiceFilePath", source = "invoiceFilePath", qualifiedByName = "file-conversion")
    Invoice invoiceDaoToInvoice(InvoiceDao invoiceDao);

    @Named("supplier-conversion")
    public static Long supplierConversion(SupplierDetails supplierCode) {
        return supplierCode.getId();
    }

    @Named("client-conversion")
    public static Long clientConversion(ClientDetails clientDetails) {
        return clientDetails.getId();
    }

    @Named("date-conversion")
    public static LocalDate DateConversion(String invoiceDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        if(invoiceDate != null && invoiceDate.trim() != "") {
            LocalDate localDate = LocalDate.parse(invoiceDate, formatter);
        }
        return LocalDate.now();
    }

    @Named("file-conversion")
    public static byte[] fileConversion(MultipartFile invoiceFilePath) {
        byte[] bytes = new byte[]{};
        try {
            bytes = invoiceFilePath.getBytes();
        } catch(Exception e) {
            throw new RuntimeException();
        }
        return bytes;
    }

}
