package com.ingweb.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ingweb.dao.ClienteDAOInterface;
import com.ingweb.dao.UsuarioDAOInterface;
import com.ingweb.dto.Ciudad;
import com.ingweb.dto.Cliente;
import com.ingweb.dto.Usuario;
import com.ingweb.exception.SuperException;

/**
 * 
 * @author William Hincapie Medina - daemonsoft@gmail.com
 * @since 1.8
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "file:springconfiguration.xml")
public class ClienteDAOHibernateTest {
	@Autowired
	ClienteDAOHibernate clienteDAO;
	/**
	 * Prueba que verifica la conexión a la base de datos consultando un cliente
	 */
	@Test
	public void obtenerTest() {
		List<Cliente> lista = null;
		try {
			lista = clienteDAO.obtener();
			assertTrue(lista.size() > 0);
		} catch (SuperException e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba que verifica la conexión a la base de datos consultando un cliente
	 */
	@Test
	public void obtenerClienteTest() {
		Cliente cliente = null;
		try {
			cliente = clienteDAO.obtener("1111");
			assertTrue(cliente != null);
		} catch (SuperException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba que verifica la conexión a la base de datos guardando un cliente
	 */
	@Test
	public void guardarTest() {
		Cliente cliente = null;
		Usuario usuario = null;
		try {
			cliente = new Cliente();
			cliente.setCedula("1233");
			cliente.setNombres("un nombre");
			cliente.setApellidos("apellidos");
			cliente.setEmail("email@gmail.com");
			usuario = new Usuario();
			usuario.setLogin("elver");
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date());

			clienteDAO.guardar(cliente);
			assertTrue(null != clienteDAO.obtener("1234"));
		} catch (SuperException e) {
			fail(e.getMessage());
		}
	}

}
