package com.ingweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import com.ingweb.exception.SuperException;
import com.ingweb.dao.UsuarioDAOInterface;
import com.ingweb.dto.Cliente;
import com.ingweb.dto.Usuario;

/**
 * 
 * @author William Hincapie Medina - daemonsoft@gmail.com
 * @since 1.8
 * @version 1.0
 */
@Transactional
public class UsuarioDAOHibernate implements UsuarioDAOInterface {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Implementación del método de la interfaz para obtener un usuario
	 */
	@Override
	public Usuario obtener(String login) throws SuperException {
		Usuario usuario = null;
		Session session = null;
		try {
			// Se obtiene una sesión a la base de datos
			session = sessionFactory.getCurrentSession();

			// Si existe la ciudad se obtiene
			usuario = (Usuario) session.get(Usuario.class, login);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new SuperException("No se pudo hacer la consulta de usuario", e.getCause());
		}
		return usuario;
	}

	@Override
	public List<Usuario> obtener() throws SuperException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Session session = null;
		Criteria criteria = null;
		try {
			// Se obtiene una sesión a la base de datos
			session = sessionFactory.getCurrentSession();

			// Se realiza la consulta
			criteria = session.createCriteria(Cliente.class);

			// Se ordenan ascendentemente por fecha de creación
			criteria.addOrder(Order.asc("fechaCreacion"));

			// Se guardan en la lista los clientes de la consulta
			usuarios = criteria.list();

		} catch (HibernateException e) {
			throw new SuperException("No se pudo realizar la consulta de las ciudades", e.getCause());

		}
		return usuarios;
	}

	@Override
	public void guardar(Usuario usuario) throws SuperException {
		Session session = null;
		try {
			// Se obtiene una sesión a la base de datos
			session = sessionFactory.getCurrentSession();

			// Se guarda el cliente y se hace la transacción
			session.save(usuario);
		} catch (HibernateException e) {
			throw new SuperException("No se pudo guardar el usuario", e.getCause());
		}
	}
}
