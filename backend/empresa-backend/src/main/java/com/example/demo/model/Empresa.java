package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Table(name="Empresa")
public class Empresa implements Serializable{
	
	private static final long serialVersionUID = -1876059308487662006L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="nombre")
	private String Nombre;
	
	@Column(name="numero_nit")
	private String NumeroNit;
	
	@Column(name="fecha_fundacion")
	private String FechaFundacion;

	@Column(name="direccion")
	private String Direccion;
	
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}



	public String getNumeroNit() {
		return NumeroNit;
	}

	public void setNumeroNit(String numeroNit) {
		NumeroNit = numeroNit;
	}

	public String getFechaFundacion() {
		return FechaFundacion;
	}

	public void setFechaFundacion(String fechaFundacion) {
		FechaFundacion = fechaFundacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Empresa [Id=" + Id + ", Nombre=" + Nombre + ", NumeroNit=" + NumeroNit + ", FechaFundacion="
				+ FechaFundacion + ", Direccion=" + Direccion + "]";
	}








	
}
