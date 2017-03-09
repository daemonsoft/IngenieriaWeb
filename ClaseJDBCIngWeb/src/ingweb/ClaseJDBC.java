package ingweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * consultar ciudades
 * 
 * @author daemonsoft@gmail.com
 *
 */
public class ClaseJDBC {

	public static void main(String[] args) {

		consultarCiudades();
	}

	/**
	 * 
	 */
	public static void consultarCiudades() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase", "root", "root");
			ps = conn.prepareStatement("select * from ciudades");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("codigo") + ": " + rs.getString("Nombre"));
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
