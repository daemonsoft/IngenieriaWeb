package com.udea.ingweb.dao;

import java.util.List;

import com.udea.ingweb.dto.Ciudad;
import com.udea.ingweb.exception.SuperException;

/**
 * Interface de la ciudad 
 * @author daemonsoft
 * @since 1.8
 * @version 1.0
 */
public interface CiudadDAOInterface {
	/**
	 * Firma del método para obtener la lista de ciudades
	 * @return 
	 * @throws SuperException
	 */
	public List<Ciudad> obtener() throws SuperException;
	/**
	 * Firma del método para obtener una ciudad
	 * @param codigo
	 * @return Ciudad con codigo ingresado como parámetro
	 * @throws SuperException
	 */
	public Ciudad obtener(Long codigo) throws SuperException;

}
