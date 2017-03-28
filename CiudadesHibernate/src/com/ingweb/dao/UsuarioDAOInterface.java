package com.ingweb.dao;

import com.ingweb.dto.Usuario;
import com.ingweb.exception.SuperException;

/**
 * Interface del usuario
 * 
 * @author daemonsoft
 * @since 1.8
 * @version 1.0
 */
public interface UsuarioDAOInterface {
	/**
	 * Firma del método para obtener un usuario
	 * @param login
	 * @return Usuario con login ingresado como parámetro
	 * @throws SuperException
	 */
	public Usuario obtener(String login) throws SuperException;
}
