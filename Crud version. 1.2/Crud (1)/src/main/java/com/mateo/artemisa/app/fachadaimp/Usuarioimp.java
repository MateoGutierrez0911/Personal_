package com.mateo.artemisa.app.fachadaimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateo.artemisa.app.fachada.IUsuario;
import com.mateo.artemisa.app.modelo.Usuarios;
import com.mateo.artemisa.app.util.JPAUtil;

public class Usuarioimp implements IUsuario{
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@Override
	public List<Usuarios> obtenerTodos() {
		List<Usuarios> listaUsuario = new ArrayList<Usuarios>();
		Query hql = entity.createQuery("SELECT us FROM Usuarios us");
		listaUsuario = hql.getResultList();
		return listaUsuario;
	}

	@Override
	public Usuarios obtenerPorId(int idUsuario) {
		Usuarios us = new Usuarios();
		us = entity.find(Usuarios.class, idUsuario);
		return us;
	}

	@Override
	public void crearUsuarios(Usuarios usuarios) {
		entity.getTransaction().begin();
		entity.persist(usuarios);
		entity.getTransaction().commit();
	}

	@Override
	public void editarUsuarios(Usuarios usuarios) {
		entity.getTransaction().begin();
		entity.merge(usuarios);
		entity.getTransaction().commit();
		
	}

	@Override
	public void eliminarUsuarios(int idUsuario) {
		Usuarios us = new Usuarios();
		us = entity.find(Usuarios.class, idUsuario);
		entity.getTransaction().begin();
		entity.remove(us);
		entity.getTransaction().commit();
		
	}
	
	

}