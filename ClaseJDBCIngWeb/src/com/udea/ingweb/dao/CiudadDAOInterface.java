package com.udea.ingweb.dao;

import java.util.List;

import com.udea.ingweb.dto.Ciudad;
import com.udea.ingweb.exception.SuperException;

/**
 * 
 * @author daemonsoft
 * @since 1.8
 * @version 1.0
 */
public interface CiudadDAOInterface {
	/**
	 * 
	 * @return
	 * @throws SuperException
	 */
	public List<Ciudad> obtener() throws SuperException;
}
