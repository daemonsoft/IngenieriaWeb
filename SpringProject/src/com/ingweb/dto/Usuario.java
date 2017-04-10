package com.ingweb.dto;

/**
 * DTO que representa a un usuario en la base de datos
 * 
 * @author William Hincapie Medina - daemonsoft@gmail.com
 * @since 1.8
 * @version 1.0
 */
public class Usuario {
	private String login;
	private String nombres;
	private String apellido;
	private String contrasena;
	private Rol rol;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
}
