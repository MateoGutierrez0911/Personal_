package com.mateo.artemisa.app.fachadaimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateo.artemisa.app.fachada.IVisitas;
import com.mateo.artemisa.app.modelo.Usuarios;
import com.mateo.artemisa.app.modelo.Visitas;
import com.mateo.artemisa.app.util.JPAUtil;

public class Visitaimp implements IVisitas{
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public List<Visitas> obtenerTodos() {
		List<Visitas> listaVisitas = new ArrayList<Visitas>();
		Query hql = entity.createQuery("SELECT vs FROM Visitas vs");
		listaVisitas = hql.getResultList();
		return listaVisitas;
	}

	@Override
	public Visitas obtenerPorId(int idVisita) {
		Visitas vis = new Visitas();
		vis = entity.find(Visitas.class, idVisita);
		return vis;
	}

	@Override
	public void crearVisitas(Visitas visitas) {
		entity.getTransaction().begin();
		entity.persist(visitas);
		entity.getTransaction().commit();
	}

	@Override
	public void editarVisitas(Visitas visitas) {
		entity.getTransaction().begin();
		entity.merge(visitas);
		entity.getTransaction().commit();
		
	}

	@Override
	public void eliminarVisitas(int idVisita) {
		Visitas vis = new Visitas();
		vis = entity.find(Visitas.class, idVisita);
		entity.getTransaction().begin();
		entity.remove(vis);
		entity.getTransaction().commit();
	}

}
