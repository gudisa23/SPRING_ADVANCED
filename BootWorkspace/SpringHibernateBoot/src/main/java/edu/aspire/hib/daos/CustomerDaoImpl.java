package edu.aspire.hib.daos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.aspire.pojos.Customer;

@Repository("custdao")
public class CustomerDaoImpl implements CustomerDao {
	@Autowired(required=true)
	private HibernateTemplate hibernateTemplate;

	public CustomerDaoImpl() {}

	@Override
	@Transactional(readOnly = false)
	public void save(final Customer c) {
		// short cut approach
		hibernateTemplate.save(c);
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
