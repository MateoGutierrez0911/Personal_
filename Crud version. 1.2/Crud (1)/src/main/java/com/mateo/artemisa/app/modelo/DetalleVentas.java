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
@Table(name = "DetalleVentas")
public class DetalleVentas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleVenta;

	@Column
	private int cantidadProducto;

	@Column
	private int valorProducto;

	@Column
	private int iva;

	@Column
	private int valorTotal;
	
	@Column
	private Date created_at;

	@Column
	private Date updated_at;

	@ManyToOne
	@JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
	private Ventas venta;

	@ManyToOne
	@JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
	private Productos producto;

	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public int getValorProducto() {
		return valorProducto;
	}

	public void setValorProducto(int valorProducto) {
		this.valorProducto = valorProducto;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
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

	public Ventas getVenta() {
		return venta;
	}

	public void setVenta(Ventas venta) {
		this.venta = venta;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public DetalleVentas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleVentas(int idDetalleVenta, int cantidadProducto, int valorProducto, int iva, int valorTotal,
			Date created_at, Date updated_at, Ventas venta, Productos producto) {
		super();
		this.idDetalleVenta = idDetalleVenta;
		this.cantidadProducto = cantidadProducto;
		this.valorProducto = valorProducto;
		this.iva = iva;
		this.valorTotal = valorTotal;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.venta = venta;
		this.producto = producto;
	}


}
