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
@Table(name="Alquiler")
public class Alquileres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlquiler;
	
	@Column
	private Date fechaAlquiler;
	
	@Column 
	private int valorTotal;
	
	@Column 
	private Date created_at;

	@Column 
	private Date updated_at;
	
    @ManyToOne
    @JoinColumn(name="idUsuario", referencedColumnName="idUsuario")
	 private Usuarios usuario;

    
    public int getIdAlquiler() {
		return idAlquiler;
	}


	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}


	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}


	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}


	public int getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
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


	public Usuarios getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}


	public Alquileres() {
		// TODO Auto-generated constructor stub
	}


	public Alquileres(int idAlquiler, Date fechaAlquiler, int valorTotal, Date created_at, Date updated_at,
			Usuarios usuario) {
		super();
		this.idAlquiler = idAlquiler;
		this.fechaAlquiler = fechaAlquiler;
		this.valorTotal = valorTotal;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.usuario = usuario;
	}
	
		
}
