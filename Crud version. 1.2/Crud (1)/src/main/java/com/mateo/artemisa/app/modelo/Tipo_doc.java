package com.mateo.artemisa.app.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tipo_doc")
public class Tipo_doc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDoc;
	
	@Column
	private String tipoDoc;

	public int getIdDoc() {
		return idDoc;
	}

	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public Tipo_doc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo_doc(int idDoc, String tipoDoc) {
		super();
		this.idDoc = idDoc;
		this.tipoDoc = tipoDoc;
	}

}
