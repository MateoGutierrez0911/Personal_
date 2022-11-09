package com.mateo.artemisa.app.fachadaimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateo.artemisa.app.fachada.IRol;
import com.mateo.artemisa.app.modelo.Rol;
import com.mateo.artemisa.app.util.JPAUtil;

public class Rolimp implements IRol{

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public List<Rol> obtenerTodos() {
		List<Rol> listaRol = new ArrayList<Rol>();
		Query hql = entity.createQuery("SELECT rl FROM Rol rl");
		listaRol = hql.getResultList();
		return listaRol;
	}
	
	//buscar rol
	@Override
	public Rol obtenerPorId(int idRol) {
		Rol rl = new Rol();
		rl = entity.find(Rol.class, idRol);
		return rl;
	}

}
