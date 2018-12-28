package edu.aspire.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AspireWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.htm" };
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { AspireWebRootConfig.class };
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
}
