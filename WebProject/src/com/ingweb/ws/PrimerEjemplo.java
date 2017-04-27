package com.ingweb.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("saludo")
public class PrimerEjemplo {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String saludar() {
		return "Hola";
	}

	@POST
	@Path("save")
	@Produces(MediaType.TEXT_HTML)
	public String otroSaludo(@QueryParam("name") String name) {
		return "Otro " + name;
	}
	
	@GET
	@Path("otro/{name}")
	@Produces(MediaType.TEXT_HTML)
	public String otroSaludoPath(@PathParam("name") String name) {
		return "Otro " + name;
	}
}
