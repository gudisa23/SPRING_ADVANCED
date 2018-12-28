package edu.aspire.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.aspire.config.SpringProgTxsConfig;
import edu.aspire.tx.programmatic.ITransferMoney;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringProgTxsConfig.class})
public class SpringProgTxsTest {
	@Autowired
	ApplicationContext context;
	
	@Test
	public void testSpringProgTxs() {
		ITransferMoney transMoney = (ITransferMoney)context.getBean("transferMoney");
		transMoney.transfer(1, 1);
		System.out.println("successfully transferred...");
	}
}
