package com.udea.ingweb.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.udea.ingweb.dao.CiudadDAOInterface;
import com.udea.ingweb.dto.Ciudad;
import com.udea.ingweb.exception.SuperException;

public class CiudadDAOImplTest {
	/**
	 * Prueba que verifica la conexión a la base de datos consultando todas las ciudades
	 */
	@Test
	public void testObtener() {
		CiudadDAOInterface ciudadDAOImpl = null;
		List<Ciudad> lista = null;
		try {
			ciudadDAOImpl = new CiudadDAOImpl();
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
			ciudadDAOImpl = new CiudadDAOImpl();
			ciudad = ciudadDAOImpl.obtener(1L);
			assertTrue(ciudad != null);
		} catch (SuperException e) {
			fail(e.getMessage());
		}
	}
}
