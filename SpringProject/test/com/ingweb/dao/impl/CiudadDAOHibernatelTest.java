package com.ingweb.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ingweb.dao.CiudadDAOInterface;
import com.ingweb.dto.Ciudad;
import com.ingweb.dto.Cliente;
import com.ingweb.exception.SuperException;

import javassist.ClassPath;

/**
 * 
 * @author William Hincapie Medina - daemonsoft@gmail.com
 * @since 1.8
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "file:springconfiguration.xml")
public class CiudadDAOHibernatelTest {

	@Autowired
	CiudadDAOHibernate ciudadDAOImpl;

	/**
	 * Prueba que verifica la conexión a la base de datos consultando todas las
	 * ciudades
	 */
	@Test
	public void testObtener() {

		List<Ciudad> lista = null;
		try {
			lista = ciudadDAOImpl.obtener();
			//
			assertTrue(lista.size() > 0);
		} catch (SuperException e) {
			fail(e.getMessage());

		}
	}

	/**
	 * Prueba que verifica la conexión a la base de datos consultando una ciudad
	 */
	@Test
	public void testObtenerCiudad() {
		Ciudad ciudad = null;
		try {
			ciudad = ciudadDAOImpl.obtener(1L);
			assertTrue(ciudad != null);
		} catch (SuperException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Prueba que verifica la conexión a la base de datos almacenando una ciudad
	 */
	@Test
	public void guardarTest() {
		Ciudad ciudad = new Ciudad();
		ciudad.setCodigo(999L);
		ciudad.setNombre("Nombre de la ciudad");
		try {
			ciudadDAOImpl.guardar(ciudad);
			assertTrue(null != ciudadDAOImpl.obtener(999L));
		} catch (SuperException e) {
			fail(e.getMessage());
		}

	}
}
