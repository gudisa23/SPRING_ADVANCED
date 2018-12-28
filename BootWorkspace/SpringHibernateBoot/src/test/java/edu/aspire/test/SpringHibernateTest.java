package edu.aspire.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.aspire.config.SpringHibernateConfig;
import edu.aspire.hib.daos.CustomerDao;
import edu.aspire.pojos.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringHibernateConfig.class})
public class SpringHibernateTest {
	@Autowired
	ApplicationContext context;
	
	@Test
	public void testSpringHibernate() {
		CustomerDao custDao = (CustomerDao) context.getBean("custdao");
		Customer c = new Customer();
		c.setCno(1);
		c.setCname("ramesh");
		c.setAddress("Ameerpet");
		c.setPhone(7799108899L);
		custDao.save(c);
		System.out.println("Record inserted successfully...");
	}
}
