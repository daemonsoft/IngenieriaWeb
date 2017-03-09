package com.udea.ingweb.dto;

/**
 * DTO que representa a una ciudad en la base de datos
 * 
 * @author daemonsoft
 * @since 1.8
 * @version 1.0
 *
 */
public class Ciudad {
	private long codigo;
	private String nombre;
	private String codigoArea;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}

}
