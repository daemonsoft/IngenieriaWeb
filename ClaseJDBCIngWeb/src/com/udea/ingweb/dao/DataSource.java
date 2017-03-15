package com.udea.ingweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.udea.ingweb.exception.SuperException;

/**
 * Clase para usada para crear una conexión a la base de datos
 * 
 * @author daemonsoft
 * @since 1.8
 * @version 1.0
 *
 */
public class DataSource {
	private static Connection conn = null;

	private DataSource() {
	}

	/**
	 * Metodo que retorna la conexión a la base de datos
	 * 
	 * @return
	 * @throws SuperException
	 */
	public static Connection getSingleConnection() throws SuperException {

		try {
			if (null == conn || conn.isClosed()) {
				// Carga del driver
				Class.forName("com.mysql.jdbc.Driver");
				// Se establece la conexión
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase", "root", "root");
			}

		} catch (ClassNotFoundException e) {
			// Se lanza si no se encuentra la libreria que contiene el driver
			throw new SuperException("Driver no encontrado");
		} catch (SQLException e) {
			// Se lanza si no se establece una conexión
			throw new SuperException("No se pudo establecer conexión");
		}
		return conn;

	}

}
