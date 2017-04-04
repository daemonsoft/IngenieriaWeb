package com.ingweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.ingweb.dao.ClienteDAOInterface;
import com.ingweb.dao.DataSource;
import com.ingweb.dto.Ciudad;
import com.ingweb.dto.Cliente;
import com.ingweb.exception.SuperException;

public class ClienteDAOHibernate implements ClienteDAOInterface {

	@Override
	public List<Cliente> obtener() throws SuperException {
		List<Cliente> clientes = new ArrayList<>();
		Session session = null;
		Criteria criteria = null;
		try {
			// Se obtiene una sesión a la base de datos
			session = DataSource.getInstance().getSession();

			// Se realiza la consulta
			criteria = session.createCriteria(Cliente.class);

			// Se ordenan ascendentemente por fecha de creación
			criteria.addOrder(Order.asc("fechaCreacion"));

			// Se guardan en la lista los clientes de la consulta
			clientes = criteria.list();

		} catch (HibernateException e) {
			throw new SuperException("No se pudo realizar la consulta de las ciudades", e);

		} finally {
			if (null != session) {
				session.close();
			}
		}
		return clientes;
	}

	@Override
	public Cliente obtener(String cedula) throws SuperException {
		Cliente cliente = null;
		Session session = null;
		try {
			// Se obtiene una sesión a la base de datos
			session = DataSource.getInstance().getSession();

			// Se guardan en la lista los clientes de la consulta
			cliente = (Cliente) session.get(Cliente.class, cedula);

		} catch (HibernateException e) {
			throw new SuperException("No se pudo realizar la consulta del cliente", e);

		} finally {
			if (null != session) {
				session.close();
			}
		}
		return cliente;
	}

	@Override
	public void guardar(Cliente cliente) throws SuperException {
		Session session = null;
		Transaction tx = null;
		try {
			// Se obtiene una sesión a la base de datos
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			// Se guarda el cliente y se hace la transacción
			session.save(cliente);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new SuperException("No se pudo guardar el cliente", e);
		} finally {
			// Se cierra la sesión
			if (null != session) {
				session.close();
			}
		}

	}

}
