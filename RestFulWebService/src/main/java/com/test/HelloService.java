package com.test;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/text")
	public String simplePlainTextResponse()
	{
		return "Holla amigo, this is simple restful web service";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/card/{debit}")
	public String htmlTextRespond(@PathParam("debit")String card)
	{
		return "<html><head><h1> response debit card no: "+card+"</h1></head></html>";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String greetUserResponse(@QueryParam("msg") String msg)
	{
		return msg;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetails> listAllUsersData()
	{
		UserDetails u1 = new UserDetails(1, "devraj","padikal","java@cricket.com",229933988);
		UserDetails u2 = new UserDetails(2, "ms","dhoni","thala@cricket.com",382368238);
		return List.of(u1,u2);
	}
}
