/* Thanks to Spring documentation on how to Create a Deployable War File 
 * https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/html/howto-traditional-deployment.html
 */
package com.weapp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The Class ServletInitializer.
 * This is to make use of Spring Framework’s Servlet 3.0 support 
 * configure application when it is launched by the servlet container
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Configure.
	 *
	 * @param application the application
	 * @return the spring application builder
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WeAppApplication.class);
	}

}
