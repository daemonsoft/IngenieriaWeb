package com.ingweb.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingweb.business.UsuarioBusiness;
import com.ingweb.exception.SuperException;

@Path("usuario")
@Component
public class UsuarioWS {
	
	@Autowired
	UsuarioBusiness usuarioBusiness;
	
	@GET
	@Path("login")
	@Produces(MediaType.TEXT_HTML)
	public String autenticar(@QueryParam("login") String login, @QueryParam("pass") String pass) {
		String retorno = "";
		try{
			usuarioBusiness.validarLogin(login, pass);
		}catch (SuperException e) {
			return e.getMessage();
		}
		return retorno;
	}
}
