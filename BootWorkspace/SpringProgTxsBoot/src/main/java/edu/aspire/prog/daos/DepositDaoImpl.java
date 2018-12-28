package edu.aspire.prog.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import edu.aspire.pojos.Deposit;

@Repository
public class DepositDaoImpl{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Deposit read(int id) {
		return (Deposit) hibernateTemplate.get(Deposit.class, new Integer(id));
	}

	public void update(Deposit w) {
		hibernateTemplate.update(w);
	}
}
