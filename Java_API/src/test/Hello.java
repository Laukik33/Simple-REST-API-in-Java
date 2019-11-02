package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello")
public class Hello {

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHelloXML()
	{
		String resource = "<? xml version='1.0' ?>" + "<hello> Hey! Welcome to my API XML </hello>";
		return resource;
	}
	
	
	
//	@GET
//	@Produces(MediaType.TEXT_HTML)
//	public String sayHelloHTML()
//	{
//		String resource = "<h1>Hey! THis is hello from HTML </h1>";
//		return resource;
//	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String checkCredit(@QueryParam("name") String name,@QueryParam("Card_no") String Card_no, @QueryParam("amount") int amount)
	{
		System.out.println("Name is "+name);
		System.out.println("Amount is "+amount);
		String response;
		
		if(amount> 10000) {
			System.out.println("amount is greater than 10000");
			response = "Credit card is not approved";
		}
		else {
			System.out.println("amount is less than 10000");
			response = "Credit card is approved";
		}
		
		return "<html>" + "<title>" + "Credit Card Authorization" + name +"</title>"+ 
		"<body><h1>" + response + "</h1></body>" +"</html>";
	}
}
