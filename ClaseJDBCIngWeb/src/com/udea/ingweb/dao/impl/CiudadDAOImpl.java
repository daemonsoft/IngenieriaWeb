package com.udea.ingweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.udea.ingweb.dao.CiudadDAOInterface;
import com.udea.ingweb.dao.DataSource;
import com.udea.ingweb.dto.Ciudad;
import com.udea.ingweb.exception.SuperException;

/**
 * Implementación de la interfaz CiudadDAO
 * 
 * @author daemonsoft
 * @since 1.8
 * @version 1.0
 *
 */
public class CiudadDAOImpl implements CiudadDAOInterface {
	/**
	 * Implementación del método de la interfaz para obtener la lista de 
	 * ciudades 
	 * @throws SuperException
	 */
	@Override
	public List<Ciudad> obtener() throws SuperException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Ciudad> ciudades = new ArrayList<>();
		try {
			//Se obtiene una conexion a la base de datos
			conn = DataSource.getSingleConnection();
			//Se crea la consulta
			ps = conn.prepareStatement("select * from ciudades");
			rs = ps.executeQuery();
			//Se guardan en la lista las ciudades en la consulta para retornarlas
			while (rs.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				ciudades.add(ciudad);
			}
		} catch (SQLException e) {
			throw new SuperException("No se pudo hacer la consulta");
		} finally {
			//Se cierran las conexiones
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				//Se lanza una exepción en caso de error
				throw new SuperException("No se pudo cerrar la conexión");
			}
		}
		return ciudades;
	}
	/**
	 * Implementación del método de la interfaz para obtener una ciudad
	 */
	@Override
	public Ciudad obtener(Long codigo) throws SuperException {
		Ciudad ciudad = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//Se obtiene una conexion a la base de datos
			conn = DataSource.getSingleConnection();
			//Se crea la consulta
			ps = conn.prepareStatement("select * from ciudades where codigo=?");
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			//Si existe la ciudad se obtienen los campos
			if (rs.next()) {
				ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				
			}
		} catch (SQLException e) {
			throw new SuperException("No se pudo hacer la consulta");
		} finally {
			//Se cierran las conexiones
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				//Se lanza una exepción en caso de error
				throw new SuperException("No se pudo cerrar la conexión");
			}
		}
		return ciudad;
	}

}
