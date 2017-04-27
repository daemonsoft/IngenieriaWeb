package com.ingweb.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingweb.business.ClienteBusiness;
import com.ingweb.dto.Cliente;
import com.ingweb.dto.ClienteJersey;
import com.ingweb.exception.SuperException;

@Path("cliente")
@Component
public class ClienteWS {

	@Autowired
	ClienteBusiness clienteBusiness;

	@POST
	@Produces(MediaType.TEXT_HTML)
	public void guardar(@QueryParam("cedula") String cedula, @QueryParam("nombres") String nombres,
			@QueryParam("apellidos") String apellidos, @QueryParam("email") String email,
			@QueryParam("usuarioCrea") String usuarioCrea) throws SuperException {
		try {
			clienteBusiness.guardar(cedula, nombres, apellidos, email, usuarioCrea);
		} catch (SuperException e) {
			throw new SuperException("No se pudo crear el usuario.");
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteJersey> obtener() throws SuperException {
		List<ClienteJersey> clientes = new ArrayList<ClienteJersey>();
		try {
			for (Cliente cliente : clienteBusiness.obtener()) {
				clientes.add(new ClienteJersey(cliente.getCedula(), cliente.getNombres(), cliente.getApellidos(),
						cliente.getEmail()));
			}
		} catch (SuperException e) {
			throw new SuperException("No se pudieron obtener los clientes.");
		}

		return clientes;
	}
}
