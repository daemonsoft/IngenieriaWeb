package com.ingweb.dto;

import javax.xml.bind.annotation.XmlRootElement;

//Permite convertir el objeto a JSON o XML
@XmlRootElement
public class ClienteJersey {

	private String cedula;
	private String nombres;
	private String apellidos;
	private String email;

	public ClienteJersey(String cedula, String nombres, String apellidos, String email) {
		super();
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
	}

	public ClienteJersey() {
		super();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
