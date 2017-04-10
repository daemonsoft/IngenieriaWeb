package com.ingweb.dao;

import java.util.List;

import com.ingweb.dto.Cliente;
import com.ingweb.exception.SuperException;

/**
 * Interface del cliente
 * 
 * @author William Hincapie Medina - daemonsoft@gmail.com
 * @since 1.8
 * @version 1.0
 */
public interface ClienteDAOInterface {
	/**
	 * Firma del método para obtener la lista de Clientes
	 * 
	 * @return
	 * @throws SuperException
	 */
	public List<Cliente> obtener() throws SuperException;

	/**
	 * Firma del método para obtener un cliente
	 * 
	 * @param cedula
	 * @return Cliente con la cédula ingresada como parámetro
	 * @throws SuperException
	 */
	public Cliente obtener(String cedula) throws SuperException;

	/**
	 * Firma del método para almacenar un Cliente en base de datos
	 * 
	 * @param cliente
	 *            Cliente a guardar
	 * @throws SuperException
	 */
	public void guardar(Cliente cliente) throws SuperException;
}