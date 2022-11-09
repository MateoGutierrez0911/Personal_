package com.mateo.artemisa.app.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoVentaAlquiler")
public class TipoVentaAlquileres {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int idTipoVentaAlquiler;
     
     @Column
     private String descTipo;

	public int getIdTipoVentaAlquiler() {
		return idTipoVentaAlquiler;
	}

	public void setIdTipoVentaAlquiler(int idTipoVentaAlquiler) {
		this.idTipoVentaAlquiler = idTipoVentaAlquiler;
	}

	public String getDescTipo() {
		return descTipo;
	}

	public void setDescTipo(String descTipo) {
		this.descTipo = descTipo;
	}

	public TipoVentaAlquileres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoVentaAlquileres(int idTipoVentaAlquiler, String descTipo) {
		super();
		this.idTipoVentaAlquiler = idTipoVentaAlquiler;
		this.descTipo = descTipo;
	}

	
     
     
}