package edu.aspire.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.aspire.config.SpringDataJpaConfig;
import edu.aspire.daos.ICustomerDao;
import edu.aspire.entities.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringDataJpaConfig.class})
public class SpringDataJpaTest {
	@Autowired
	ApplicationContext context;
	
	@Autowired
	ICustomerDao custDao;
	
	@Test
	public void testInsertJpa() {
		Customer c = new Customer();
		c.setCname("ramesh");
		c.setAddress("Ameerpet");
		c.setPhone(7799108899L);
		custDao.save(c);
	}
	
	/*@Test
	public void testReadJpa() {
		Customer c = custDao.findOne(1);
		System.out.println(c.getCno() + "  " + c.getCname() +" " + c.getAddress() +"  " + c.getPhone());
	}
	
	@Test
	public void testUpdateJpa(){
		Customer c = custDao.findOne(1);
		c.setPhone(7799208899L);
		custDao.save(c); //In Spring Data JPA the save() is either persist() or merge() based on primary key present or not.
	}
	
	@Test
	public void testDeleteJpa(){
		Customer c = custDao.findOne(1);
		custDao.delete(c);
	}

	@Test
	public void testFindAllJpa(){
		List<Customer> custs = custDao.findAll();
		System.out.println("***FindAll***:" + custs.size());
	}
	
	@Test
	public void testFindByNameJpa(){
		List<Customer> custs = custDao.findByCname("ramesh");
		System.out.println("***FindByCname***:" + custs.size());
	}*/
}
