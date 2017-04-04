package com.ingweb.dao;

import java.util.List;

import com.ingweb.dto.Cliente;
import com.ingweb.exception.SuperException;

public interface ClienteDAOInterface {

	public List<Cliente> obtener() throws SuperException;
	public Cliente obtener(String cedula) throws SuperException;
	public void guardar(Cliente cliente) throws SuperException;
}