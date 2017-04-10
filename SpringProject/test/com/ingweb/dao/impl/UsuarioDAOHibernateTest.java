package com.ingweb.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ingweb.dao.UsuarioDAOInterface;
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
public class UsuarioDAOHibernateTest {
	
	@Autowired
	UsuarioDAOHibernate usuarioDAO;
	/**
	 * Prueba que verifica la conexión a la base de datos consultando un usuario
	 */
	@Test
	public void testObtener() {
		Usuario usuario = null;
		try {
			usuario = usuarioDAO.obtener("juan");
			assertTrue(usuario != null);
			System.out.println("Usuario: " + usuario.getLogin() + " - Rol: " + usuario.getRol().getNombre());
		} catch (SuperException e) {
			fail(e.getMessage());
		}
	}
}
