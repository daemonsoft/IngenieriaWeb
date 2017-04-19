package com.ingweb.business;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ingweb.dao.impl.ClienteDAOHibernate;
import com.ingweb.dao.impl.UsuarioDAOHibernate;
import com.ingweb.dto.Cliente;
import com.ingweb.dto.Usuario;
import com.ingweb.exception.SuperException;

/**
 * Clase para manejar la lógica de negocio del objeto Cliente
 * 
 * @author William Hincapie Medina - daemonsoft@gmail.com
 * @since 1.8
 * @version 1.0
 */
public class ClienteBusiness {
	private ClienteDAOHibernate clienteDAOHibernate;
	private UsuarioDAOHibernate usuarioDAOHibernate;

	public ClienteDAOHibernate getClienteDAOHibernate() {
		return clienteDAOHibernate;
	}

	public void setClienteDAOHibernate(ClienteDAOHibernate clienteDAOHibernate) {
		this.clienteDAOHibernate = clienteDAOHibernate;
	}
	
	public UsuarioDAOHibernate getUsuarioDAOHibernate() {
		return usuarioDAOHibernate;
	}

	public void setUsuarioDAOHibernate(UsuarioDAOHibernate usuarioDAOHibernate) {
		this.usuarioDAOHibernate = usuarioDAOHibernate;
	}

	/**
	 * Método para obener la lista de clientes
	 * 
	 * @return Lista de todos los clientes
	 * @throws SuperException
	 */
	public List<Cliente> obtener() throws SuperException {

		return clienteDAOHibernate.obtener();
	}

	/**
	 * Método para guardar un cliente
	 * 
	 * @param cedula
	 *            Identificación del Cliente
	 * @param nombres
	 *            Nombres del CLiente
	 * @param apellidos
	 *            Apellidos del Cliente
	 * @param email
	 *            Correo del Cliente
	 * @param usuarioCrea
	 *            Usuario que crea el cliente
	 * @throws SuperException
	 */
	public void guardar(String cedula, String nombres, String apellidos, String email, String usuarioCrea)
			throws SuperException {
		Usuario usuario = usuarioDAOHibernate.obtener(usuarioCrea);
		if (null == cedula || "".equals(cedula)) {
			throw new SuperException("La cedula no puede estar vacia.");
		} else if (clienteDAOHibernate.obtener(cedula) != null) {
			throw new SuperException("La cedula ya se encuentra registrada.");
		}
		if (null == nombres || "".equals(nombres)) {
			throw new SuperException("El nombre no puede estar vacio.");
		}
		if (null == apellidos || "".equals(apellidos)) {
			throw new SuperException("El apellido no puede estar vacio.");
		}
		if (null == email || "".equals(email)) {
			throw new SuperException("El email no puede estar vacio.");
		} else if (!validate(email)) {
			throw new SuperException("El email no es válido.");
		}
		if (null == usuarioCrea || "".equals(usuarioCrea)) {
			throw new SuperException("El usuario creador no puede estar vacio.");
		}

		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setNombres(nombres);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean.FALSE);

		clienteDAOHibernate.guardar(cliente);
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	/**
	 * Metodo para validar el correo
	 * 
	 * @param emailStr
	 * @return
	 */
	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

}
