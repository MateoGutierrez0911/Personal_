package com.mateo.artemisa.app.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.mateo.artemisa.app.fachadaimp.Visitaimp; 
import com.mateo.artemisa.app.fachadaimp.TipoVentaAlquilerimp;
import com.mateo.artemisa.app.fachadaimp.Usuarioimp;
import com.mateo.artemisa.app.fachadaimp.Productoimp;
import com.mateo.artemisa.app.modelo.TipoVentaAlquileres;
import com.mateo.artemisa.app.modelo.Usuarios;
import com.mateo.artemisa.app.modelo.Visitas;
import com.mateo.artemisa.app.modelo.Productos;



@ManagedBean(name="visitaBean")
@RequestScoped
public class VisitasBean {

	private Visitaimp visitaimp = new Visitaimp();
	
	private Usuarioimp usuarioimp = new Usuarioimp();
	
	private Productoimp productoimp = new Productoimp();
	
	private TipoVentaAlquilerimp tipoVentaAlquilerimp = new TipoVentaAlquilerimp();
	
	private Visitas visita = new Visitas();
	
	private Usuarios usuario = new Usuarios(); 
	
	private Productos producto =  new Productos();

	private TipoVentaAlquileres tipoVentaAlquiler =  new TipoVentaAlquileres();

	private List<Usuarios> listaUsuarios;
	
	private List<Productos> listaProductos;
	
	private List<TipoVentaAlquileres> listaTipoVentaAlquileres;
	
	///
	
	public List<Usuarios> getListaUsuarios() {
		return usuarioimp.obtenerTodos(); 
	}

	public void setListaUsuarios(List<Usuarios> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public List<Productos> getListaProductos() {
		return productoimp.obtenerTodos(); 
	}

	public void setListaProductos(List<Productos> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public List<TipoVentaAlquileres> getListaTipoVentaAlquileres() {
		return tipoVentaAlquilerimp.obtenerTodos();
	}

	public void setListaTipoVentaAlquileres(List<TipoVentaAlquileres> listaTipoVentaAlquileres) {
		this.listaTipoVentaAlquileres = listaTipoVentaAlquileres;
	}


	public Visitas getVisita() {
		return visita;
	}

	public void setVisita(Visitas visita) {
		this.visita = visita;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public TipoVentaAlquileres getTipoVentaAlquiler() {
		return tipoVentaAlquiler;
	}

	public void setTipoVentaAlquiler(TipoVentaAlquileres tipoVentaAlquiler) {
		this.tipoVentaAlquiler = tipoVentaAlquiler;
	}

	public VisitasBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public VisitasBean(Visitas visita, Usuarios usuario, Productos producto, TipoVentaAlquileres tipoVentaAlquiler) {
		super();
		this.visita = visita;
		this.usuario = usuario;
		this.producto = producto;
		this.tipoVentaAlquiler = tipoVentaAlquiler;
	}

	public List<Visitas> obtenerTodos(){
		List<Visitas> lista = new ArrayList<Visitas>();
		lista = visitaimp.obtenerTodos();
		return lista;
	}
	
	public String nuevo(){
    	return "registroVisita.xhtml?faces-redirect=true";
    }

	public String crear() { 
		visita.setUsuario(usuario);
		visita.setProducto(producto);
		visita.setTipoVentaAlquiler(tipoVentaAlquiler);
		visitaimp.crearVisitas(visita);
	   	return "Visitas.xhtml?faces-redirect=true"; 
	 }
	
	
	 public String editar(int idVisita, Visitas visitas) {
		 visita = visitaimp.obtenerPorId(idVisita);
		 usuario.setIdUsuario(visitas.getUsuario().getIdUsuario());
		 producto.setIdProducto(visitas.getProducto().getIdProducto());
		 tipoVentaAlquiler.setIdTipoVentaAlquiler(visitas.getTipoVentaAlquiler().getIdTipoVentaAlquiler());
		 visita = visitas;
		 Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	     sessionMap.put("visita", visita);
		 return "editarVisita.xhtml";
	 }
	
	 public String actualizar(Visitas visitas) {
			usuario = usuarioimp.obtenerPorId(visitas.getUsuario().getIdUsuario());
		producto = productoimp.obtenerPorId(visitas.getProducto().getIdProducto());
		tipoVentaAlquiler = tipoVentaAlquilerimp.obtenerPorId(visitas.getTipoVentaAlquiler().getIdTipoVentaAlquiler());
		visitas.setUsuario(usuario);
		visitas.setProducto(producto);
		visitas.setTipoVentaAlquiler(tipoVentaAlquiler);
		visitaimp.editarVisitas(visitas);
		return "Visitas.xhtml?faces-redirect=true"; 
	 }
	 
	 public void eliminar(int idVisita) {
		 visitaimp.eliminarVisitas(idVisita);
	 }
	 
	
	
}
