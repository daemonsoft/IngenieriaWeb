package com.ingweb.dao;

import java.util.List;

import com.ingweb.dto.Ciudad;
import com.ingweb.exception.SuperException;

/**
 * Interface de la ciudad 
 * @author William Hincapie Medina - daemonsoft@gmail.com
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
	/**
	 * Firma del méodo para guardar una ciudad en la base de datos
	 * @param ciudad Ciudad que se desea guardar
	 * @throws SuperException
	 */
	public void guardar(Ciudad ciudad) throws SuperException;

}
