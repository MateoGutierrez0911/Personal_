package com.mateo.artemisa.app.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetalleAlquiler")
public class DetalleAlquileres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddetalle_Alquiler;

	@Column
	private int valorAlquiler;
	
	@Column
	private int iva;
	
	@Column 
	private Date created_at;

	@Column 
	private Date updated_at;
	
	@ManyToOne
	@JoinColumn(name="idAlquiler", referencedColumnName="idAlquiler")
	private Alquileres alquiler;
	
	@ManyToOne
	@JoinColumn(name="idProducto", referencedColumnName="idProducto")
	private Productos producto;

	public int getIddetalle_Alquiler() {
		return iddetalle_Alquiler;
	}

	public void setIddetalle_Alquiler(int iddetalle_Alquiler) {
		this.iddetalle_Alquiler = iddetalle_Alquiler;
	}

	public int getValorAlquiler() {
		return valorAlquiler;
	}

	public void setValorAlquiler(int valorAlquiler) {
		this.valorAlquiler = valorAlquiler;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Alquileres getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Alquileres alquiler) {
		this.alquiler = alquiler;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public DetalleAlquileres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleAlquileres(int iddetalle_Alquiler, int valorAlquiler, int iva, Date created_at, Date updated_at,
			Alquileres alquiler, Productos producto) {
		super();
		this.iddetalle_Alquiler = iddetalle_Alquiler;
		this.valorAlquiler = valorAlquiler;
		this.iva = iva;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.alquiler = alquiler;
		this.producto = producto;
	}

	
		
}
