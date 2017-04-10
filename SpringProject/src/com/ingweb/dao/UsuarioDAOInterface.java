package com.ingweb.dao;

import java.util.List;

import com.ingweb.dto.Cliente;
import com.ingweb.dto.Usuario;
import com.ingweb.exception.SuperException;

/**
 * Interface del usuario
 * 
 * @author William Hincapie Medina - daemonsoft@gmail.com
 * @since 1.8
 * @version 1.0
 */
public interface UsuarioDAOInterface {
	
	/**
	 * Firma del método para obtener la lista de Usuarios
	 * @return
	 * @throws SuperException
	 */
	public List<Usuario> obtener() throws SuperException;
	/**
	 * Firma del método para obtener un usuario
	 * @param login
	 * @return Usuario con login ingresado como parámetro
	 * @throws SuperException
	 */
	public Usuario obtener(String login) throws SuperException;
	
	/**
	 * Firma del método para almacenar un Usuario en base de datos
	 * @param cliente Usuario a guardar
	 * @throws SuperExceptionF
	 */
	public void guardar(Usuario usuario) throws SuperException;
}
