package edu.aspire.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication(scanBasePackages = { "edu.aspire.tx.programmatic", "edu.aspire.prog.daos" })
public class SpringProgTxsConfig {
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(ds);

		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.use_sql_comments", "true");
		props.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

		lsfb.setHibernateProperties(props);
		lsfb.setMappingResources(new String[] { "Withdraw.hbm.xml", "Deposit.hbm.xml" });

		return lsfb;
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public HibernateTemplate hibTemplate() {
		return new HibernateTemplate();
	}

	/*@Bean(autowire = Autowire.BY_TYPE)
	public HibernateTransactionManager hibTxManager() {
		return new HibernateTransactionManager();
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public TransactionTemplate txTemplate() {
		return new TransactionTemplate();
	}*/
}
