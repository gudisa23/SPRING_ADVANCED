package edu.aspire.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import edu.aspire.controllers.NewCustomerController;

@SpringBootConfiguration
@EnableAutoConfiguration
public class AspireWebRootConfig {
	/*@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("system");
		bds.setPassword("manager");
		bds.setInitialSize(10);
		bds.setMaxActive(15);
		return bds;
	}*/
	
	/*@Bean
    public DataSource dataSource() {
        JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
        dataSource.setJndiName("java:comp/env/mypool");
        try {
            dataSource.afterPropertiesSet(); //Look up the JNDI object and store it.
        } catch (IllegalArgumentExcfeption | NamingException e) {
            throw new RuntimeException(e);
        }
        return (DataSource)dataSource.getObject();
    }*/

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
		lsfb.setMappingResources(new String[] { "Customer.hbm.xml" });

		return lsfb;
	}

	@Bean(autowire=Autowire.BY_TYPE)
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate();
	}
	
	@Bean(name="/nc.htm")
	public NewCustomerController custController(){
		return new NewCustomerController();
	}
	
	/*@Bean
	public BeanNameUrlHandlerMapping handlerMapping(){ //auto configured by spring boot
		return new BeanNameUrlHandlerMapping();
	}*/

	/*@Bean
	public ViewResolver viewResolver() { //auto configured by spring boot
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(InternalResourceView.class);
		return resolver;
	}*/
}


