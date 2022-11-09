package com.mateo.artemisa.app.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categoria")
public class Categorias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoriaProducto;
	  
	@Column(name="categoriaProducto")
	private String categoriaProducto;

	public int getIdCategoriaProducto() {
		return idCategoriaProducto;
	}

	public void setIdCategoriaProducto(int idCategoriaProducto) {
		this.idCategoriaProducto = idCategoriaProducto;
	}

	public String getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public Categorias() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorias(int idCategoriaProducto, String categoriaProducto) {
		super();
		this.idCategoriaProducto = idCategoriaProducto;
		this.categoriaProducto = categoriaProducto;
	}
	
	
}
