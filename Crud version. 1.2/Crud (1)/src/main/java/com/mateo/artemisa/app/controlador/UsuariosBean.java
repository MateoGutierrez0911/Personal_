package com.mateo.artemisa.app.controlador;

//import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.mateo.artemisa.app.fachadaimp.Rolimp;
import com.mateo.artemisa.app.fachadaimp.Tipodocimp;
import com.mateo.artemisa.app.fachadaimp.Usuarioimp;
import com.mateo.artemisa.app.modelo.Rol;
import com.mateo.artemisa.app.modelo.Tipo_doc;
import com.mateo.artemisa.app.modelo.Usuarios;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuariosBean {

	private Usuarioimp usuarioimp = new Usuarioimp();
	
	private Tipodocimp tipodocImp = new Tipodocimp();
	
	private Rolimp rolImp = new Rolimp();
	
	private Usuarios usuario = new Usuarios();
	
	private Tipo_doc tipo_doc = new Tipo_doc(); 
	
	private Rol rol =  new Rol();

	private List<Tipo_doc> listaTipDoc;
	
	private List<Rol> listaRol;
		
		////	
	public List<Tipo_doc> getListaTipDoc() {
		return tipodocImp.obtenerTodos();
	}

	public void setListaTipDoc(List<Tipo_doc> listaTipDoc) {
		this.listaTipDoc = listaTipDoc;
	}

	public List<Rol> getListaRol() {
		return rolImp.obtenerTodos();
	}

	public void setListaRol(List<Rol> listaRol) {
		this.listaRol = listaRol;
	}
	
	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Tipo_doc getTipo_doc() {
		return tipo_doc;
	}

	public void setTipo_doc(Tipo_doc tipo_doc) {
		this.tipo_doc = tipo_doc;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public UsuariosBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuariosBean(Usuarios usuario, Tipo_doc tipo_doc, Rol rol) {
		super();
		this.usuario = usuario;
		this.tipo_doc = tipo_doc;
		this.rol = rol;
	}
		
	public List<Usuarios> obtenerTodos(){
		List<Usuarios> lista = new ArrayList<Usuarios>();
		lista = usuarioimp.obtenerTodos();
		return lista;
	}
	
	public String nuevo(){
    	return "registroUsuario.xhtml?faces-redirect=true";
    }
	
	 public String crear() { 
	   	usuario.setTipo_Doc(tipo_doc);  
	   	usuario.setRol(rol); 
	   	usuarioimp.crearUsuarios(usuario);
	   	return "Usuarios.xhtml?faces-redirect=true"; 
	 }
	 
	 public String editar(int idUsuario, Usuarios usuarios) {
		 usuario = usuarioimp.obtenerPorId(idUsuario);
		 tipo_doc.setIdDoc(usuarios.getTipo_Doc().getIdDoc());
		 rol.setIdRol(usuarios.getRol().getIdRol());
		 usuario = usuarios;
	     Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	     sessionMap.put("usuario", usuario);
		 return "editarUsuario.xhtml";
	 }
	
	 public String actualizar(Usuarios usuarios) {
		tipo_doc = tipodocImp.obtenerPorId(usuarios.getTipo_Doc().getIdDoc());  
		rol = rolImp.obtenerPorId(usuarios.getRol().getIdRol());
		usuarios.setTipo_Doc(tipo_doc);
		usuarios.setRol(rol);
		usuarioimp.editarUsuarios(usuarios); 
		return "Usuarios.xhtml?faces-redirect=true"; 
	 }
	 
	 public void eliminar(int idUsuario) {
		 usuarioimp.eliminarUsuarios(idUsuario);
	 }
	 
}
