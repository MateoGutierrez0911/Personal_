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
@Table(name="Ventas")
public class Ventas {
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int idVenta;
	 
	 @Column
	 private Date fechaVenta;
	 
	 @Column
	 private int valorTotal;
	 
	 @Column
     private Date created_at;
     
     @Column
     private Date updated_at;
     
     @ManyToOne
     @JoinColumn(name="idUsuario", referencedColumnName="idUsuario")
	 private Usuarios usuario;
     
     
public int getIdVenta() {
		return idVenta;
	}


	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}


	public Date getFechaVenta() {
		return fechaVenta;
	}


	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
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


public Ventas() {
	// TODO Auto-generated constructor stub
}


public Ventas(int idVenta, Date fechaVenta, int valorTotal, Date created_at, Date updated_at, Usuarios usuario) {
	super();
	this.idVenta = idVenta;
	this.fechaVenta = fechaVenta;
	this.valorTotal = valorTotal;
	this.created_at = created_at;
	this.updated_at = updated_at;
	this.usuario = usuario;
}
	     
}
