package com.mateo.artemisa.app.fachadaimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateo.artemisa.app.fachada.IAlquiler;
import com.mateo.artemisa.app.modelo.Alquileres;
import com.mateo.artemisa.app.util.JPAUtil;

public class Alquilerimp implements IAlquiler {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();	
	@Override
	public List<Alquileres> obtenerTodos() {
		List<Alquileres> listaAlquiler = new ArrayList<Alquileres>();
		Query hql = entity.createQuery("SELECT alq FROM Alquileres alq");
		listaAlquiler = hql.getResultList();
		return listaAlquiler;
	}

	@Override
	public Alquileres obtenerPorId(int idalquiler) {
		Alquileres alq = new Alquileres();
		alq = entity.find(Alquileres.class, idalquiler);
		return alq;
	}

	@Override
	public void createAlquiler(Alquileres alquiler) {
		entity.getTransaction().begin();
		entity.persist(alquiler);
		entity.getTransaction().commit();
	}

	@Override
	public void editarAlquiler(Alquileres alquiler) {
		entity.getTransaction().begin();
		entity.merge(alquiler);
		entity.getTransaction().commit();
	}

	@Override
	public void eliminarAlquiler(int idalquiler) {
		Alquileres alq = new Alquileres();
		alq = entity.find(Alquileres.class, idalquiler);
		entity.getTransaction().begin();
		entity.remove(alq);
		entity.getTransaction().commit();
		
	}

}
