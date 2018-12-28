package edu.aspire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.aspire.model.CustomerDao;
import edu.aspire.view.vo.Customer;

@Service
public class CustomerService { //business class
	@Autowired
	private CustomerDao customerDao;

	public int processCustomer(Customer c){
		return customerDao.save(c);
	}
}
