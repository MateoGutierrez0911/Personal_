package com.mateo.artemisa.app.fachada;

import java.util.List;

import com.mateo.artemisa.app.modelo.Tipo_doc;

public interface ITipoDoc {
	public List<Tipo_doc> obtenerTodos();
	public Tipo_doc obtenerPorId(int idDoc);
	public void crearTipoDoc(Tipo_doc tipo_doc);
	public void editarTipoDoc(Tipo_doc tipo_doc);
	public void eliminarTipoDoc(int idDoc);

}
