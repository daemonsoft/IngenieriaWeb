package com.ingweb.dto;

public class Direccion {

	private DireccionId id;
	private String telefono;
	private String direccion;
	private Ciudad ciudad;
	private Boolean preferida;

	public DireccionId getId() {
		return id;
	}

	public void setId(DireccionId id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Boolean getPreferida() {
		return preferida;
	}

	public void setPreferida(Boolean preferida) {
		this.preferida = preferida;
	}

}
