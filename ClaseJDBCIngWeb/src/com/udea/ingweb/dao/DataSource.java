package com.udea.ingweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.udea.ingweb.exception.SuperException;

/**
 * Clase que retorna una conexión a la base de datos
 * 
 * @author daemonsoft
 * @since 1.8
 * @version 1.0
 *
 */
public class DataSource {
	/**
	 * 
	 * @return
	 * @throws SuperException
	 */
	public static Connection getConnection() throws SuperException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase", "root", "root");
			conn.close();
		} catch (ClassNotFoundException e) {
			throw new SuperException("Driver no encontrado");
		} catch (SQLException e) {
			throw new SuperException("No se pudo establecer conexión");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new SuperException("No se pudo cerrar la conexión");
			}
		}
		return null;

	}

}
