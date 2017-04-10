package com.ingweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import com.ingweb.dao.ClienteDAOInterface;
import com.ingweb.dto.Cliente;
import com.ingweb.exception.SuperException;

/**
 * 
 * @author William Hincapie Medina - daemonsoft@gmail.com
 * @since 1.8
 * @version 1.0
 */
public class ClienteDAOHibernate implements ClienteDAOInterface {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Cliente> obtener() throws SuperException {
		List<Cliente> clientes = new ArrayList<>();
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
			clientes = criteria.list();

		} catch (HibernateException e) {
			throw new SuperException("No se pudo realizar la consulta de las ciudades", e.getCause());

		}
		return clientes;
	}

	@Override
	public Cliente obtener(String cedula) throws SuperException {
		Cliente cliente = null;
		Session session = null;
		try {
			// Se obtiene una sesión a la base de datos
			session = sessionFactory.getCurrentSession();

			// Se guardan en la lista los clientes de la consulta
			cliente = (Cliente) session.get(Cliente.class, cedula);

		} catch (HibernateException e) {
			throw new SuperException("No se pudo realizar la consulta del cliente", e.getCause());

		}
		return cliente;
	}

	@Override
	public void guardar(Cliente cliente) throws SuperException {
		Session session = null;
		try {
			// Se obtiene una sesión a la base de datos
			session = sessionFactory.getCurrentSession();

			// Se guarda el cliente y se hace la transacción
			session.save(cliente);
		} catch (HibernateException e) {
			throw new SuperException("No se pudo guardar el cliente", e.getCause());
		}

	}

}
