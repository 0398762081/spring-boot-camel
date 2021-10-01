package vn.molu.Route;

import java.util.Date;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.molu.entity.Rout;
import vn.molu.repository.RoutRepository;

@Service
public class SimpleRouteBuilder extends RouteBuilder {

	@Autowired
	private RoutRepository routRepository;

	@Override
	public void configure() throws Exception {
		/*
		 * from("file:D:\\demoCamel\\input?noop=true")
		 * .to("file:D:\\demoCamel\\output");
		 */
		from("file:DemoCamel\\input?noop=true").process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {

			}
		}).to("file:DemoCamel\\output").process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {

				/* String fileContent = exchange.getIn().getBody(String.class); */
				/* exchange.getIn().setBody(fileContent.toUpperCase()); */
				Map<String, Object> map = exchange.getIn().getHeaders();
				Rout rout = new Rout();
				rout.setFileName((String) map.get("CamelFileName"));
				rout.setSourceFolder((String) map.get("CamelFileParent"));
				String string = new String((String) map.get("CamelFileNameProduced"));
				rout.setDestinationFolder(string.substring(0, 16));
				Long longs = (Long) map.get("CAMELMESSAGETIMESTAMP");
				Date date = new Date(longs);
				rout.setCopyDate(date);
				if (routRepository != null) {
					routRepository.save(rout);
				}
//						routRepository.save(rout);
			}
		});
	}

}
