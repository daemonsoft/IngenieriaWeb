package com.ingweb.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.ingweb.dao.CiudadDAOInterface;
import com.ingweb.dto.Ciudad;
import com.ingweb.exception.SuperException;

public class CiudadDAOHibernatelTest {
	/**
	 * Prueba que verifica la conexión a la base de datos consultando todas las ciudades
	 */
	@Test
	public void testObtener() {
		CiudadDAOInterface ciudadDAOImpl = null;
		List<Ciudad> lista = null;
		try {
			ciudadDAOImpl = new CiudadDAOHibernate();
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
		CiudadDAOInterface ciudadDAOImpl = null;
		Ciudad ciudad = null;
		try {
			ciudadDAOImpl = new CiudadDAOHibernate();
			ciudad = ciudadDAOImpl.obtener(1L);
			assertTrue(ciudad != null);
		} catch (SuperException e) {
			fail(e.getMessage());
		}
	}
}
