package com.ingweb.dto;

import java.util.Date;

/**
 * DTO que representa a un cliente en la base de datos
 * 
 * @author daemonsoft
 * @since 1.8
 * @version 1.0
 */
public class Cliente {
	private String cedula;
	private String nombres;
	private String apellidos;
	private String email;
	private String usuarioCrea;
	private Date fechaCreacion;
	private String usuarioModifica;
	private Date fechaModificacion;
	private boolean eliminado;
	private String usuarioElimina;
	private Date fechaEliminacion;

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

	public String getUsuasioCrea() {
		return usuarioCrea;
	}

	public void setUsuasioCrea(String usuasioCrea) {
		this.usuarioCrea = usuasioCrea;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioModifica() {
		return usuarioModifica;
	}

	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public String getUsuarioElimina() {
		return usuarioElimina;
	}

	public void setUsuarioElimina(String usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}

	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

}