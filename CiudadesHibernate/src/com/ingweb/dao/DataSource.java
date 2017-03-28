package com.ingweb.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ingweb.exception.SuperException;

/**
 * Clase para obtener una sesión a la base de datos implementando el patrón
 * singleton
 * 
 * @author daemonsoft
 * @version 1.0
 * @since 1.8
 */
public class DataSource {
	private static DataSource instance;
	private SessionFactory sessionFactory;
	private Configuration configuration = new Configuration();
	/**
	 * Constructor privado para evitar que sea instanciada la clase por fuera 
	 */
	private DataSource() {
	}
	/**
	 * Método para obtener una instancia de la clase
	 * @return la instancia de la clase
	 */
	public static DataSource getInstance() {
		if (null == instance) {
			instance = new DataSource();
		}
		return instance;
	}
	/**
	 * Método para retornar una sesión a la base de datos
	 * @return
	 * @throws SuperException
	 */
	public Session getSession() throws SuperException {
		try {
			if (null == sessionFactory) {
				configuration.configure("hibernate.cfg.xml");
				sessionFactory = configuration.buildSessionFactory();
			}
			return sessionFactory.openSession();
		} catch (HibernateException e) {
			throw new SuperException("Error configurando la session " + e);
		}
	}
}
