package com.ingweb.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ingweb.dao.ClienteDAOInterface;
import com.ingweb.dao.UsuarioDAOInterface;
import com.ingweb.dto.Cliente;
import com.ingweb.dto.Usuario;
import com.ingweb.exception.SuperException;

public class ClienteDAOHibernateTest {

	@Test
	public void obtenerTest() {
		ClienteDAOInterface clienteDAOImpl = null;
		List<Cliente> lista = null;
		try {
			clienteDAOImpl = new ClienteDAOHibernate();
			lista = clienteDAOImpl.obtener();
			//
			assertTrue(lista.size() > 0);
		} catch (SuperException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void guardarTest(){
		Cliente cliente = null;
		ClienteDAOInterface clienteDAO = null;
		Usuario usuario = null;
		UsuarioDAOInterface usuarioDAO = null;
		try{
			cliente = new Cliente();
			cliente.setCedula("1234");
			cliente.setNombres("un nombre");
			cliente.setApellidos("apellidos");
			cliente.setEmail("email@gmail.com");
			usuario = new Usuario();
			usuario.setLogin("elver");
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date());
			
			clienteDAO = new ClienteDAOHibernate();
			clienteDAO.guardar(cliente);
			assertTrue(null != clienteDAO.obtener("1234"));
		}catch (SuperException e) {
			fail(e.getMessage());
		}
	}

}
