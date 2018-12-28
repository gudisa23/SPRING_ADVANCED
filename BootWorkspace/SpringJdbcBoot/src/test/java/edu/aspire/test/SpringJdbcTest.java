package edu.aspire.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.aspire.config.SpringJdbcConfig;
import edu.aspire.daos.EmployeeDao;
import edu.aspire.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes={SpringJdbcConfig.class})
@SpringBootTest(classes={SpringJdbcConfig.class})

//The below annotations are needed in case of auto configuration.
/*
@SpringBootConfiguration
@ComponentScan(basePackages = {"edu.aspire.daos"})
@EnableAutoConfiguration
*/

//The above three annotations together is same as @SpringBootApplication.
//@SpringBootApplication(scanBasePackages = {"edu.aspire.daos"})
//Note: It is good practice to add these annotations in spring configuration file if exists.
public class SpringJdbcTest {
	@Autowired
	ApplicationContext context;
	@Test
	public void testSpringJdbc() {
		
		EmployeeDao empdao = (EmployeeDao)context.getBean("empdao");
		
		Employee e = new Employee();
		e.setEno(1);
		e.setEname("Ramesh");
		e.setDesig("Director");
		e.setSal(1000.0);
		empdao.save(e);
		System.out.println("Record inserted successfully...");
		
		System.out.println("Read customer details");
		Employee emp = empdao.get(1);
		System.out.println(emp.getEno()+"\t"+emp.getEname()+"\t"+emp.getDesig()+"\t"+emp.getSal());
	}
}
