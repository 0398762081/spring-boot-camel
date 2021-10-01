package vn.molu;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vn.molu.Route.SimpleRouteBuilder;

@SpringBootApplication
public class SpringBootCamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCamelApplication.class, args);
		
		CamelContext context = new DefaultCamelContext();
		try {
			context.addRoutes(new SimpleRouteBuilder());
			while (true) {
				context.start();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
