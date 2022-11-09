package com.mateo.artemisa.app.fachadaimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateo.artemisa.app.fachada.IDetalleVenta;
import com.mateo.artemisa.app.modelo.DetalleVentas;
import com.mateo.artemisa.app.util.JPAUtil;

public class DetalleVentaimp implements IDetalleVenta{
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public List<DetalleVentas> obtenerTodos() {
		List<DetalleVentas> listaDetalleVentas = new ArrayList<DetalleVentas>();
		Query hql = entity.createQuery("SELECT dv FROM DetalleVentas dv");
		listaDetalleVentas = hql.getResultList();
		return listaDetalleVentas;
	}

	@Override
	public DetalleVentas obtenerPorId(int idDetalleVenta) {
		DetalleVentas dtv = new DetalleVentas();
		dtv = entity.find(DetalleVentas.class, idDetalleVenta);
		return dtv;
	}

	@Override
	public void crearDetalleVenta(DetalleVentas detalleVenta) {
		entity.getTransaction().begin();
		entity.persist(detalleVenta);
		entity.getTransaction().commit();
	}

	@Override
	public void editarDetalleVenta(DetalleVentas detalleVenta) {
		entity.getTransaction().begin();
		entity.merge(detalleVenta);
		entity.getTransaction().commit();
		
	}

	@Override
	public void eliminarDetalleVenta(int idDetalleVenta) {
		DetalleVentas dtv = new DetalleVentas();
		dtv = entity.find(DetalleVentas.class, idDetalleVenta);
		entity.getTransaction().begin();
		entity.remove(dtv);
		entity.getTransaction().commit();
	}

}
