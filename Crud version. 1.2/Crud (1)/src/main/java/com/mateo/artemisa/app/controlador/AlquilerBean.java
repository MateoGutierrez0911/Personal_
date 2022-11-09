package com.mateo.artemisa.app.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.mateo.artemisa.app.fachadaimp.Alquilerimp;
import com.mateo.artemisa.app.fachadaimp.Usuarioimp;
import com.mateo.artemisa.app.modelo.Alquileres;
import com.mateo.artemisa.app.modelo.Usuarios;


@ManagedBean(name="alquilerBean")
@RequestScoped
public class AlquilerBean {
	
	private Alquilerimp alquilerimp = new Alquilerimp();
	
	private Usuarioimp usuarioimp = new Usuarioimp();

	private Alquileres alquiler = new Alquileres();
	
	private Usuarios usuario = new Usuarios();
	
	private List<Usuarios> listaUsuarios;

		
	public List<Usuarios> getListaUsuarios() {
		return usuarioimp.obtenerTodos(); 
	}

	public void setListaUsuarios(List<Usuarios> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}


	public Alquileres getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Alquileres alquiler) {
		this.alquiler = alquiler;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public AlquilerBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public AlquilerBean(Alquileres alquiler, Usuarios usuario) {
		super();
		this.alquiler = alquiler;
		this.usuario = usuario;
	}

	public List<Alquileres> obtenerTodos(){
		List<Alquileres> lista = new ArrayList<Alquileres>();
		lista = alquilerimp.obtenerTodos();
		return lista;
	}
	
	public String nuevo(){
    	return "registroAlquiler.xhtml?faces-redirect=true";
    }

	public String crear() { 
		alquiler.setUsuario(usuario);
		alquilerimp.createAlquiler(alquiler);
		return "Alquiler.xhtml?faces-redirect=true"; 
	 }
	
	 public String editar(int idAlquiler, Alquileres alquileres) {
		 alquiler = alquilerimp.obtenerPorId(idAlquiler);		 
		 usuario.setIdUsuario(alquileres.getUsuario().getIdUsuario());	
		 alquiler = alquileres;
		 Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	     sessionMap.put("alquiler", alquiler);
		 return "editarAlquiler.xhtml";
	 }
		 
	 
	 public String actualizar(Alquileres alquileres) {
		usuario = usuarioimp.obtenerPorId(alquileres.getUsuario().getIdUsuario());
		alquileres.setUsuario(usuario); 
		alquilerimp.editarAlquiler(alquileres);
		return "Alquiler.xhtml?faces-redirect=true"; 
	 }
	 
	 
	 
	 
	 public void eliminar(int idAlquiler) {
		 alquilerimp.eliminarAlquiler(idAlquiler);
	 }
	
}
