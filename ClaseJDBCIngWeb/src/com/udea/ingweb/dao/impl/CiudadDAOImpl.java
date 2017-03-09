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
	 * @throws SuperException
	 */
	@Override
	public List<Ciudad> obtener() throws SuperException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Ciudad> ciudades = new ArrayList<>();
		try {

			conn = DataSource.getConnection();
			ps = conn.prepareStatement("select * from ciudades");
			rs = ps.executeQuery();
			while (rs.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(Long.parseLong(rs.getString("codigo")));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				ciudades.add(ciudad);
			}
			conn.close();
		} catch (SQLException e) {
			throw new SuperException("No se pudo hacer la consulta");
		} finally {
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
				throw new SuperException("No se pudo cerrar la conexión");
			}
		}
		return ciudades;
	}

}
