package com.research.services.config;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.research.services" })
public class AppConfig{

}
