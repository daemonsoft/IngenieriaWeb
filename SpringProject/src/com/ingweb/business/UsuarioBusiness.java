package com.ingweb.business;

import java.util.List;

import org.hibernate.type.TrueFalseType;

import com.ingweb.dao.impl.UsuarioDAOHibernate;
import com.ingweb.dto.Rol;
import com.ingweb.dto.Usuario;
import com.ingweb.exception.SuperException;

/**
 * Clase para manejar la lógica de negocio del objeto Usuario
 * 
 * @author William Hincapie Medina - daemonsoft@gmail.com
 * @since 1.8
 * @version 1.0
 */
public class UsuarioBusiness {
	private UsuarioDAOHibernate usuarioDAOHibernate;

	public UsuarioDAOHibernate getUsuarioDAOHibernate() {
		return usuarioDAOHibernate;
	}

	public void setUsuarioDAOHibernate(UsuarioDAOHibernate usuarioDAOHibernate) {
		this.usuarioDAOHibernate = usuarioDAOHibernate;
	}

	/**
	 * Método para obtener un usuario dado el login
	 * 
	 * @param login
	 * @return Usuario con login ingresado
	 * @throws SuperException
	 */
	public Usuario obtener(String login) throws SuperException {
		if (null == login || "".equals(login)) {
			throw new SuperException("El login no puede estar vacio.");
		}
		return usuarioDAOHibernate.obtener(login);
	}

	/**
	 * Método para obtener la lista de usuarios
	 * 
	 * @return Lista de usuarios
	 * @throws SuperException
	 */
	public List<Usuario> obtener() throws SuperException {
		return usuarioDAOHibernate.obtener();
	}

	/**
	 * Método para guardar un usuario
	 * 
	 * @param login
	 *            login del usuario
	 * @param contrasena
	 *            Contraseña del usuario
	 * @param nombres
	 *            Nombres del usuario
	 * @param apellido
	 *            Apellidos del usuario
	 * @param codigoRol
	 *            Código del rol que tiene el usuario
	 * @throws SuperException
	 */
	public void guardar(String login, String contrasena, String nombres, String apellido, String codigoRol)
			throws SuperException {
		// Validación de los parámetros ingresados
		if (null == login || "".equals(login)) {
			throw new SuperException("El login no puede estar vacio.");
		} else if (usuarioDAOHibernate.obtener(login) != null) {
			throw new SuperException("El login ya se encuentra registrado.");
		}
		if (null == nombres || "".equals(nombres)) {
			throw new SuperException("El nombre no puede estar vacio.");
		}
		if (null == apellido || "".equals(apellido)) {
			throw new SuperException("El apellido no puede estar vacio.");
		}
		if (null == codigoRol || "".equals(codigoRol)) {
			throw new SuperException("El rol no puede estar vacio.");
		}
		if (null == contrasena || "".equals(contrasena)) {
			throw new SuperException("La contraseña no puede estar vacia.");
		}
		// Creación del usuario
		Rol rol = new Rol();
		rol.setCodigo(codigoRol);
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setNombres(nombres);
		usuario.setApellido(apellido);
		usuario.setContrasena(contrasena);
		usuario.setRol(rol);
		// Se almacena el usuario
		usuarioDAOHibernate.guardar(usuario);
	}

	/**
	 * Método para validar si se ingreso correctamente el login y la contraseña
	 * 
	 * @param login
	 *            Login del usuario
	 * @param contrasena
	 *            Contraseña del usuario
	 * @return true en caso de existir un usuario con las credenciales
	 *         ingresadas, false de lo contrario
	 * @throws SuperException
	 */
	public boolean validarLogin(String login, String contrasena) throws SuperException {
		if (null == contrasena || "".equals(contrasena)) {
			throw new SuperException("La contraseña no puede estar vacia.");
		}
		if (null == login || "".equals(login)) {
			throw new SuperException("El login no puede estar vacio.");
		}
		Usuario usuario = usuarioDAOHibernate.obtener(login);
		if (null == usuario) {
			return Boolean.FALSE;
		} else if (usuario.getContrasena().equals(contrasena)) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}

	}

}
