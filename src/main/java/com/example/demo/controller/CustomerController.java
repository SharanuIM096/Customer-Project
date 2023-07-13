package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Customer;
import com.example.demo.service.CustomerService;
import com.example.response.ResponseStructure;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/persist")
	public ResponseEntity<?> insertCustomer(@RequestBody Customer customer) {
		ResponseStructure<?> responseStructure = customerService.insertCustomer(customer);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpstatus());
	}

	@GetMapping(path = "/fetchAll")
	public ResponseEntity<?> findAllCustomer() {
		ResponseStructure<?> responseStructure = customerService.findAllCustomer();

		return new ResponseEntity<>(responseStructure, responseStructure.getHttpstatus());

	}

	@GetMapping(path = "/getbyid")
	public ResponseEntity<?> findbyid(@RequestHeader Integer custid) {
		ResponseStructure<?> responseStructure = customerService.findbyid(custid);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpstatus());
	}

	@DeleteMapping(path = "/deletebyid")
	public ResponseEntity<?> deleteCustomer(@RequestHeader Integer custid) {
		ResponseStructure<?> responseStructure = customerService.deleteCustomer(custid);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpstatus());
	}

	// update the customer
	// putmapping---update complte resource
	// patch---only specific attibute of na customer

	@PutMapping("/update")
	public ResponseEntity<?> updatecustomer(@RequestBody Customer customer) {
		ResponseStructure<?> responseStructure = customerService.updatecustomer(customer);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpstatus());
	}
	@PatchMapping("/updatephono")
	public ResponseEntity<?> updatecustphono(@RequestHeader Integer custid, @RequestHeader Long phono) {
		ResponseStructure<?> responseStructure = customerService.updatecustphono(custid,phono);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpstatus());
	}
	
	

}
