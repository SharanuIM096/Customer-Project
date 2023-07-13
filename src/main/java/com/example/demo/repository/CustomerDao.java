package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Customer;
import com.example.demo.exception.CustomerIdNotFoundException;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer insertCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> findAllCustomer() {
		
		return customerRepository.findAll();
	}
	
	public Customer findbyid(Integer custid) {
Optional<Customer> findById=customerRepository.findById(custid);
		
		if(findById.isPresent()) {
			customerRepository.findById(custid);
			return findById.get();
		}
		throw new CustomerIdNotFoundException("customer id is not avialable");
	}
		
	
	
	public Customer deleteCustomer(Integer custid) {
		Optional<Customer> findById=customerRepository.findById(custid);
		
		if(findById.isPresent()) {
			customerRepository.deleteById(custid);
			return findById.get();
		}
		throw new CustomerIdNotFoundException("customer id is not avialable");
	}

	public Customer updatecustomer(Customer customer) {
		Optional<Customer> findById=customerRepository.findById( customer.getCustid());
		
		if(findById.isPresent()) {
			return customerRepository.save(customer);
		}
		throw new CustomerIdNotFoundException("customer Id not available for updation");
	}

	public Customer updatecustphono(Integer custid, Long phono) {
		Optional<Customer> findById=customerRepository.findById( custid);
		if(findById.isPresent()) {
			Customer cust=findById.get();
			cust.setPhono(phono);
			return customerRepository.save(cust);
		}
		throw new CustomerIdNotFoundException("customer Id not available for phono upadation");
	}
	
}
