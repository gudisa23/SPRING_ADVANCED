package edu.aspire.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.aspire.entities.Customer;

@Repository("custdao")
@Transactional
public class CustomerDaoImpl implements ICustomerDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(Customer c) {
		em.persist(c);
		System.out.println("Customer details successfully inserted");
	}

	@Override
	public Customer read(int cno) {
		return em.find(Customer.class, cno);
	}

	@Override
	public void update(Customer c) {
		em.merge(c);
		System.out.println("Customer details successfully modified");
	}

	@Override
	public void delete(Customer c) {
		em.remove(em.merge(c));	
		System.out.println("Customer details successfully deleted");
	}
	
	@Override
	public List<Customer> findAll(){
		Query q = em.createNamedQuery("cust.findAll");
		return q.getResultList();
	}
	
	@Override
	public List<Customer> findByName(String cname){
		Query q = em.createNamedQuery("cust.findByName");
		q.setParameter(1, cname);
		return q.getResultList();
	}
}
