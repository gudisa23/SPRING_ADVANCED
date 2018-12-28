package edu.aspire.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.aspire.view.vo.Customer;
//CREATE TABLE CUSTOMER(CID NUMBER(3)PRIMARY KEY, CNAME VARCHAR2(100), EMAIL VARCHAR2(100), MOBILE VARCHAR2(20));
//CREATE SEQUENCE CUSTOMER_SEQ;
@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired(required = true)
	private HibernateTemplate hibernateTemplate;

	public CustomerDaoImpl() {
	}

	@Override
	@Transactional(readOnly = false)
	public int save(Customer c) {
		return (Integer) hibernateTemplate.save(c);
	}

	@Override
	public void delete(int eno) {
	}

	@Override
	public Customer get(int eno) {
		return null;
	}

	@Override
	public void update(Customer e) {
	}
}
