package edu.datafusion.CarRental;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
		basePackages = "edu.datafusion.CarRental.repository", repositoryImplementationPostfix = "Manager")
public class CarRentalApplication {

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CarRentalApplication.class, args);
	}

	/**
	 * Redirect all http calls to https.
	 * @return
	 */
	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context){
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcatServletWebServerFactory.addAdditionalTomcatConnectors(redirectConnector());
		return tomcatServletWebServerFactory;
	}

	/**
	 * Listen on 80 and redirect to 443
	 * @return
	 */
	private Connector redirectConnector(){
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(9090);
		connector.setRedirectPort(8443);
		return connector;
	}

}
