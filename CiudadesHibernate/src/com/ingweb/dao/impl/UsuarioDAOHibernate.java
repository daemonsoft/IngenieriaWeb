package com.ingweb.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ingweb.dao.DataSource;
import com.ingweb.exception.SuperException;
import com.ingweb.dao.UsuarioDAOInterface;
import com.ingweb.dto.Usuario;

public class UsuarioDAOHibernate implements UsuarioDAOInterface {
	/**
	 * Implementación del método de la interfaz para obtener un usuario
	 */
	@Override
	public Usuario obtener(String login) throws SuperException {
		Usuario usuario = null;
		Session session = null;
		try {
			// Se obtiene una sesión a la base de datos
			session = DataSource.getInstance().getSession();

			// Si existe la ciudad se obtiene
			usuario = (Usuario) session.get(Usuario.class, login);
		} catch (HibernateException e) {
			throw new SuperException("No se pudo hacer la consulta de usuario", e);
		} finally {
			// Se cierra la sesión
			if (null != session) {
				session.close();
			}
		}
		return usuario;
	}

}
