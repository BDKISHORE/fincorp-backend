package com.capstone.fincrop.controller;

import com.capstone.fincrop.dao.InvoiceDao;
import com.capstone.fincrop.dao.InvoiceMapper;
import com.capstone.fincrop.model.Register;
import com.capstone.fincrop.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;

	@Autowired
	InvoiceMapper invoiceMapper;

	@CrossOrigin("*")
	@GetMapping("/list")
	List<InvoiceDao> list() {
		return invoiceService.list().stream().map(invoiceMapper::invoiceToInvoiceDao).collect(Collectors.toList());
	}

	@CrossOrigin("*")
	@GetMapping("/list/{userId}")
	List<InvoiceDao> listByUser(@PathVariable("userId") Long userId) {
		return invoiceService.listUserId(userId).stream().map(invoiceMapper::invoiceToInvoiceDao).collect(Collectors.toList());
	}

	@CrossOrigin("*")
	@PostMapping(value="/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Register> create(@RequestParam("supplierCode") Long supplierCode, @RequestParam("user") Long user,
									@RequestParam(name = "invoiceDate", required = false) String invoiceDate, @RequestParam(name = "invoiceNumber", required = false) String invoiceNumber,
									@RequestParam(name = "invoiceCurrency", required = false) String invoiceCurrency, @RequestParam(name = "invoiceAmount", required = false) Double invoiceAmount,
									@RequestPart("invoiceFilePath") MultipartFile invoiceFilePath) {
		InvoiceDao invoiceDao = new InvoiceDao();
		invoiceDao.setInvoiceDate(invoiceDate);
		invoiceDao.setSupplierCode(supplierCode);
		invoiceDao.setInvoiceNumber(invoiceNumber);
		invoiceDao.setCurrency(invoiceCurrency);
		invoiceDao.setInvoiceAmount(invoiceAmount);

		byte[] bytes = new byte[]{};
		try {
			bytes = invoiceFilePath.getBytes();
		} catch(Exception e) {
			throw new RuntimeException();
		}

		invoiceDao.setInvoiceFilePath(bytes);
		try {
			return ResponseEntity.ok(invoiceService.save(invoiceDao, user));
		} catch(Exception e) {
			e.printStackTrace();
			Register register = new Register("500", "Something went wrong, please register once again");
			return ResponseEntity.ok(register);
		}
	}

}
