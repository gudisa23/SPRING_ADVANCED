package edu.aspire.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AspireWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { AspireWebConfig.class };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { AspireRootConfig.class };
	}
}
