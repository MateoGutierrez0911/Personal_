package com.mateo.artemisa.app.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.mateo.artemisa.app.fachadaimp.Ventaimp;
import com.mateo.artemisa.app.fachadaimp.DetalleVentaimp;
import com.mateo.artemisa.app.fachadaimp.Productoimp;
import com.mateo.artemisa.app.modelo.Ventas;
import com.mateo.artemisa.app.modelo.DetalleVentas;
import com.mateo.artemisa.app.modelo.Productos;

@ManagedBean(name="detalleventaBean")
@RequestScoped
public class DetalleVentaBean {
	
	private DetalleVentaimp detalleventaimp = new DetalleVentaimp();
	
	private Ventaimp ventaimp = new Ventaimp();
	
	private Productoimp productoimp = new Productoimp();
	
	private DetalleVentas detalleventa = new DetalleVentas();
	
	private Ventas venta = new Ventas();
	
	private Productos producto = new Productos();
	
	private List<Ventas> listaVentas;
	
	private List<Productos> listaProductos;

	
	public List<Ventas> getListaVentas() {
		return ventaimp.obtenerTodos(); 
	}

	public void setListaVentas(List<Ventas> listaVentas) {
		this.listaVentas = listaVentas;
	}

	public List<Productos> getListaProductos() {
		return productoimp.obtenerTodos();
	}

	public void setListaProductos(List<Productos> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public DetalleVentas getDetalleventa() {
		return detalleventa;
	}

	public void setDetalleventa(DetalleVentas detalleventa) {
		this.detalleventa = detalleventa;
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

	public DetalleVentaBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleVentaBean(DetalleVentas detalleventa, Ventas venta, Productos producto) {
		super();
		this.detalleventa = detalleventa;
		this.venta = venta;
		this.producto = producto;
	}
	
	
	public List<DetalleVentas> obtenerTodos(){
		List<DetalleVentas> lista = new ArrayList<DetalleVentas>();
		lista = detalleventaimp.obtenerTodos();
		return lista;
	}
	
	public String nuevo(){
    	return "registroDetalleVenta.xhtml?faces-redirect=true";
    }

	public String crear() { 
		detalleventa.setVenta(venta);
		detalleventa.setProducto(producto);
		detalleventaimp.crearDetalleVenta(detalleventa);
		return "DetalleVenta.xhtml?faces-redirect=true"; 
	 }

	public String editar(int idDetalleVenta, DetalleVentas detalleventas) {
		 detalleventa = detalleventaimp.obtenerPorId(idDetalleVenta);
		 venta.setIdVenta(detalleventas.getVenta().getIdVenta());
		 producto.setIdProducto(detalleventas.getProducto().getIdProducto()); 
		 detalleventa = detalleventas;
		 Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	     sessionMap.put("detalleventa", detalleventa);
		 return "editarDetalleVenta.xhtml";
	 }

	 public String actualizar(DetalleVentas detalleventas) {
		venta = ventaimp.obtenerPorId(detalleventas.getVenta().getIdVenta());
		producto = productoimp.obtenerPorId(detalleventas.getProducto().getIdProducto()); 
		detalleventas.setVenta(venta); 
		detalleventas.setProducto(producto);
		detalleventaimp.editarDetalleVenta(detalleventas);
		return "DetalleVenta.xhtml?faces-redirect=true"; 
	 }
	 
	 public void eliminar(int idDetalleVenta) {
		 detalleventaimp.eliminarDetalleVenta(idDetalleVenta);
	 }
	
}
