package com.mateo.artemisa.app.fachadaimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateo.artemisa.app.fachada.ITipoventaalquiler;
import com.mateo.artemisa.app.modelo.TipoVentaAlquileres;
import com.mateo.artemisa.app.util.JPAUtil;



public class TipoVentaAlquilerimp implements ITipoventaalquiler{

EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	

	@Override
	public List<TipoVentaAlquileres> obtenerTodos() {
		List<TipoVentaAlquileres> listatipoventaalquiler = new ArrayList<TipoVentaAlquileres>();
		Query tva = entity.createQuery("SELECT ta FROM TipoVentaAlquileres ta");
		listatipoventaalquiler =tva.getResultList();
		return listatipoventaalquiler;
	}

	@Override
	public TipoVentaAlquileres obtenerPorId(int idTipoVentaAlquiler) {
		TipoVentaAlquileres tva = new TipoVentaAlquileres();
		tva = entity.find(TipoVentaAlquileres.class, idTipoVentaAlquiler);
		return tva;
	}

	@Override
	public void crearTipoVentaAlquiler(TipoVentaAlquileres Tipoventaalquiler) {
		entity.getTransaction().begin();
		entity.persist(Tipoventaalquiler);
		entity.getTransaction().commit();
	}

	@Override
	public void editarTipoVentaAlquiler(TipoVentaAlquileres Tipoventaalquiler) {
		entity.getTransaction().begin();
		entity.merge(Tipoventaalquiler);
		entity.getTransaction().commit();
	}

	@Override
	public void eliminarTipoVentaAlquiler(int idTipoVentaAlquiler) {
		TipoVentaAlquileres tva = new TipoVentaAlquileres();
		tva = entity.find(TipoVentaAlquileres.class, idTipoVentaAlquiler);
		entity.getTransaction().begin();
		entity.remove(tva);
		entity.getTransaction().commit();
	}

}