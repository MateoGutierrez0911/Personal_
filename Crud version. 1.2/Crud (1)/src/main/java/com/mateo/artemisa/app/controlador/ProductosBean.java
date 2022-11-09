package com.mateo.artemisa.app.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.mateo.artemisa.app.fachadaimp.Categoriaimp;
import com.mateo.artemisa.app.fachadaimp.Productoimp;
import com.mateo.artemisa.app.modelo.Categorias;
import com.mateo.artemisa.app.modelo.Productos;
import com.mateo.artemisa.app.modelo.Usuarios;

@ManagedBean(name="productoBean")
@RequestScoped
public class ProductosBean {
	
	private Productoimp productoimp = new Productoimp();
	
	private Categoriaimp categoriaimp = new Categoriaimp();
	
	private Productos producto = new Productos();
	
	private Categorias categoria = new Categorias();
	
	private List<Categorias> listaCategorias;

	public List<Categorias> getListaCategorias() {
		return categoriaimp.obtenerTodos();
	}

	public void setListaCategorias(List<Categorias> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public ProductosBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductosBean(Productos producto, Categorias categoria) {
		super();
		this.producto = producto;
		this.categoria = categoria;
	}
	
	public List<Productos> obtenerTodos() {
		List<Productos> lista = new ArrayList<Productos>();
		lista = productoimp.obtenerTodos();
		return lista;
	}
	
	public String nuevo(){
    	return "registroProducto.xhtml?faces-redirect=true";
    }
	
	 public String crear() { 
	   	producto.setCategoriaProducto(categoria);
		productoimp.crearProducto(producto); 
	   	return "Productos.xhtml?faces-redirect=true"; 
	 }
	 
	 public String editar(int idProducto, Productos productos) {
		 producto = productoimp.obtenerPorId(idProducto);
		 categoria.setIdCategoriaProducto(productos.getCategoriaProducto().getIdCategoriaProducto() );
		 producto = productos;
	     Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	     sessionMap.put("producto", producto);
		 return "editarProducto.xhtml";
	 }
	 
	 public String actualizar(Productos productos) {
		 categoria = categoriaimp.obtenerPorId(productos.getCategoriaProducto().getIdCategoriaProducto());
		 productos.setCategoriaProducto(categoria);
		 productoimp.editarProducto(productos);
		 return "Productos.xhtml?faces-redirect=true"; 
	}
	 
	 public void eliminar(int idProducto) {
		 productoimp.eliminarProducto(idProducto);
	 }
	 
}
