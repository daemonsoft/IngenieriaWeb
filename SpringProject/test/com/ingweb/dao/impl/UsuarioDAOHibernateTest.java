package com.ingweb.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ingweb.dao.UsuarioDAOInterface;
import com.ingweb.dto.Rol;
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
	 * Prueba que verifica la conexión a la base de datos consultando los
	 * usuarios
	 */
	@Test
	public void testObtenerUsusarios() {
		List<Usuario> usuarios = null;
		try {
			usuarios = usuarioDAO.obtener();
			assertTrue(usuarios.size() > 0);
		} catch (SuperException e) {
			fail(e.getMessage());
		}
	}

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

	/**
	 * Prueba que verifica la conexión a la base de datos guardando un usuario
	 */
	@Test
	public void guardarTest() {
		Usuario usuario = null;
		Rol rol = null;
		try {
			usuario = new Usuario();
			rol = new Rol();
			usuario.setNombres("nombre");
			usuario.setLogin("logintest");
			usuario.setContrasena("contraseña");
			usuario.setApellido("apellido");
			rol.setCodigo("ADM");
			usuario.setRol(rol);

			usuarioDAO.guardar(usuario);
			assertTrue(null != usuarioDAO.obtener("logintest"));
		} catch (SuperException e) {
			fail(e.getMessage());
		}
	}
}
