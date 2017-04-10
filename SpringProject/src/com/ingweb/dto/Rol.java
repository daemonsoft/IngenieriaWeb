package com.ingweb.dto;

/**
 * DTO que representa a un rol en la base de datos
 * 
 * @author William Hincapie Medina - daemonsoft@gmail.com
 * @since 1.8
 * @version 1.0
 */
public class Rol {
	private String codigo;
	private String nombre;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
