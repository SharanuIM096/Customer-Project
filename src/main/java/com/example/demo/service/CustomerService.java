package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Customer;
import com.example.demo.repository.CustomerDao;
import com.example.response.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public ResponseStructure<?> insertCustomer(Customer customer) {
		Customer cust = customerDao.insertCustomer(customer);

		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(cust);
		responseStructure.setHttpstatus(HttpStatus.CREATED);
		return responseStructure;
	}

	public ResponseStructure<?> findAllCustomer() {
		List<Customer> customerList=customerDao.findAllCustomer();
		
		ResponseStructure<List<Customer>> responseStructure=new ResponseStructure<>();
		responseStructure.setData(customerList);
		responseStructure.setHttpstatus(HttpStatus.OK);
	
		return responseStructure;
	}
	
	public ResponseStructure<?> findbyid(Integer custid){
		Customer cust1 =customerDao.findbyid(custid);
		
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(cust1);
		responseStructure.setHttpstatus(HttpStatus.CREATED);
		return responseStructure;
		
	}
	
	
	public ResponseStructure<?> deleteCustomer(Integer custid){
	Customer cust=customerDao.deleteCustomer(custid);
		
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(cust);
		responseStructure.setHttpstatus(HttpStatus.OK);
		return responseStructure;
	}

	public ResponseStructure<?> updatecustomer(Customer customer) {
		Customer cust=customerDao.updatecustomer(customer);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(cust);
		responseStructure.setHttpstatus(HttpStatus.OK);
		return responseStructure;
	}

	public ResponseStructure<?> updatecustphono(Integer custid, Long phono) {
		Customer cust=customerDao.updatecustphono(custid,phono);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(cust);
		responseStructure.setHttpstatus(HttpStatus.OK);
		return responseStructure;
	}

}
