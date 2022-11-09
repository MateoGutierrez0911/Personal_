package com.mateo.artemisa.app.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.mateo.artemisa.app.fachadaimp.Alquilerimp;
import com.mateo.artemisa.app.fachadaimp.DetalleAlquilerimp;
import com.mateo.artemisa.app.fachadaimp.Productoimp;
import com.mateo.artemisa.app.modelo.Alquileres;
import com.mateo.artemisa.app.modelo.DetalleAlquileres;
import com.mateo.artemisa.app.modelo.Productos;

@ManagedBean(name="detallealquilerBean")
@RequestScoped
public class DetalleAlquilerBean {

	private DetalleAlquilerimp detallealquilerimp = new DetalleAlquilerimp();
	
	private Alquilerimp alquilerimp = new Alquilerimp();
	
	private Productoimp productoimp = new Productoimp();
		
	private DetalleAlquileres detallealquiler = new DetalleAlquileres();
	
	private Alquileres alquiler = new Alquileres();
	
	private Productos producto = new Productos();
	
	private List<Alquileres> listaAlquileres;
	
	private List<Productos> listaProductos;

	public List<Alquileres> getListaAlquileres() {
		return alquilerimp.obtenerTodos();
	}

	public void setListaAlquileres(List<Alquileres> listaAlquileres) {
		this.listaAlquileres = listaAlquileres;
	}

	public List<Productos> getListaProductos() {
		return productoimp.obtenerTodos();
	}

	public void setListaProductos(List<Productos> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public DetalleAlquileres getDetallealquiler() {
		return detallealquiler;
	}

	public void setDetallealquiler(DetalleAlquileres detallealquiler) {
		this.detallealquiler = detallealquiler;
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

	public DetalleAlquilerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleAlquilerBean(DetalleAlquileres detallealquiler, Alquileres alquiler, Productos producto) {
		super();
		this.detallealquiler = detallealquiler;
		this.alquiler = alquiler;
		this.producto = producto;
	}
	
	public List<DetalleAlquileres> obtenerTodos(){
		List<DetalleAlquileres> lista = new ArrayList<DetalleAlquileres>();
		lista = detallealquilerimp.obtenerTodos();
		return lista;
	}
	
	public String nuevo(){
    	return "registroDetalleAlquiler.xhtml?faces-redirect=true";
    }

	public String crear() { 
		detallealquiler.setAlquiler(alquiler);
		detallealquiler.setProducto(producto);
		detallealquilerimp.crearDetalleAlquileres(detallealquiler); 
		return "DetalleAlquiler.xhtml?faces-redirect=true"; 
	 }
	
	public String editar(int idDetalle_alquiler, DetalleAlquileres detallealquileres) {
		 detallealquiler = detallealquilerimp.obtenerPorId(idDetalle_alquiler);
		 alquiler.setIdAlquiler(detallealquileres.getAlquiler().getIdAlquiler());
		 producto.setIdProducto(detallealquileres.getProducto().getIdProducto());
		 detallealquiler = detallealquileres;
		 Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	     sessionMap.put("detallealquiler", detallealquiler);
		 return "editarDetalleAlquiler.xhtml";
	 }
		 
	 public String actualizar(DetalleAlquileres detallealquileres) {
		alquiler = alquilerimp.obtenerPorId(detallealquileres.getAlquiler().getIdAlquiler()); 
		producto = productoimp.obtenerPorId(detallealquileres.getProducto().getIdProducto()); 
		detallealquileres.setAlquiler(alquiler);
		detallealquileres.setProducto(producto);
		detallealquilerimp.editarDetalleAlquileres(detallealquileres);
		return "DetalleAlquiler.xhtml?faces-redirect=true"; 
	 }
	 
	 public void eliminar(int iddetalle_Alquiler) {
		 detallealquilerimp.eliminarDetalleAlquileres(iddetalle_Alquiler); 
	 }
	
}
