package com.ingweb.dao.impl;

import static org.junit.Assert.*;


import org.junit.Test;

import com.ingweb.dao.UsuarioDAOInterface;
import com.ingweb.dto.Usuario;
import com.ingweb.exception.SuperException;

public class UsuarioDAOHibernateTest {

	/**
	 * Prueba que verifica la conexión a la base de datos consultando un usuario
	 */
	@Test
	public void testObtener() {
		UsuarioDAOInterface usuarioDAO = null;
		Usuario usuario = null;
		try {
			usuarioDAO = new UsuarioDAOHibernate();
			usuario = usuarioDAO.obtener("juan");
			assertTrue(usuario != null);
			System.out.println("Usuario: " + usuario.getLogin() + " - Rol: " + usuario.getRol().getNombre());
		} catch (SuperException e) {
			fail(e.getMessage());
		}
	}
}
