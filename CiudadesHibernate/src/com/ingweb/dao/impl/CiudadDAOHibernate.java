package com.ingweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ingweb.dao.CiudadDAOInterface;
import com.ingweb.dao.DataSource;
import com.ingweb.dto.Ciudad;
import com.ingweb.exception.SuperException;

/**
 * Implementación de la interfaz CiudadDAO
 * 
 * @author daemonsoft
 * @since 1.8
 * @version 1.0
 *
 */
public class CiudadDAOHibernate implements CiudadDAOInterface {
	/**
	 * Implementación del método de la interfaz para obtener la lista de
	 * ciudades
	 * 
	 * @throws SuperException
	 */
	@Override
	public List<Ciudad> obtener() throws SuperException {
		List<Ciudad> ciudades = new ArrayList<>();
		Session session = null;
		Criteria criteria = null;
		try {
			// Se obtiene una sesión a la base de datos
			session = DataSource.getInstance().getSession();

			// Se realiza la consulta
			criteria = session.createCriteria(Ciudad.class);

			// Se guardan en la lista las ciudades de la consulta
			ciudades = criteria.list();

		} catch (HibernateException e) {
			throw new SuperException("No se pudo realizar la consulta de las ciudades", e);

		} finally {
			if (null != session) {
				session.close();
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
		Session session = null;
		try {
			// Se obtiene una sesión a la base de datos
			session = DataSource.getInstance().getSession();

			// Si existe la ciudad se obtiene
			ciudad = (Ciudad) session.get(Ciudad.class, codigo);
		} catch (HibernateException e) {
			throw new SuperException("No se pudo hacer la consulta de ciudad", e);
		} finally {
			// Se cierra la sesión
			if (null != session) {
				session.close();
			}
		}
		return ciudad;
	}

	/**
	 * Implementación del método de la interfaz para guardar una ciudad
	 */
	@Override
	public void guardar(Ciudad ciudad) throws SuperException {
		Session session = null;
		Transaction tx = null;
		try {
			// Se obtiene una sesión a la base de datos
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			// Se guarda la ciudad y se hace la transacción
			session.save(ciudad);
			tx.commit();
		} catch (HibernateException e) {
			throw new SuperException("No se pudo guardar la ciudad", e);
		} finally {
			// se desacen los cambios
			if (null != tx) {
				tx.rollback();
			}
			// Se cierra la sesión
			if (null != session) {
				session.close();
			}
		}

	}

}
