package be.mensa.application.website.business.common;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/rest")
public class RestConfiguration extends Application {

	public RestConfiguration(@Context ServletConfig servletConfig) {

		BeanConfig beanConfig = new BeanConfig();

		beanConfig.setVersion("1.0.0");
		beanConfig.setTitle("Mensa Belgium API");
		beanConfig.setBasePath("/rest");
		beanConfig.setResourcePackage("be.mensa.application.website");
		beanConfig.setScan(true);
	}
}