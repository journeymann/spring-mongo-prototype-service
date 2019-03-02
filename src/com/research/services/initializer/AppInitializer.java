package com.research.services.initializer;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


import com.research.services.config.AppConfig;
import com.research.services.config.WebMvcConfig;


public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

    private static final String CONFIG_LOCATION = "com.research.services.config";
    private static final String MAPPING_URL = "/";

    @Override
    protected Class<?>[] getRootConfigClasses() {
    	return new Class[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
    	return new Class[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
    	return new String[] { MAPPING_URL };
    }
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(MAPPING_URL);
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        return context;
    }

}


