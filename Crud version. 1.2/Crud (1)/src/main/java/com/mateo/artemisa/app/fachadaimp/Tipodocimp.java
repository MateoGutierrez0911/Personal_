package com.mateo.artemisa.app.fachadaimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateo.artemisa.app.fachada.ITipoDoc;
import com.mateo.artemisa.app.modelo.Tipo_doc;
import com.mateo.artemisa.app.util.JPAUtil;




public class Tipodocimp implements ITipoDoc{

EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		

		@Override
		public List<Tipo_doc> obtenerTodos() {
			List<Tipo_doc> listatipo_doc = new ArrayList<Tipo_doc>();
			Query hql = entity.createQuery("SELECT td FROM Tipo_doc td");
			listatipo_doc = hql.getResultList();
			return listatipo_doc;
			
		}

		@Override
		public Tipo_doc obtenerPorId(int idDoc) {
			Tipo_doc td = new Tipo_doc();
			td = entity.find(Tipo_doc.class, idDoc);
			return td;
			
		}

		@Override
		public void crearTipoDoc(Tipo_doc tipo_doc) {
			entity.getTransaction().begin();
			entity.persist(tipo_doc);
			entity.getTransaction().commit();
			
		}

		@Override
		public void editarTipoDoc(Tipo_doc tipo_doc) {
			entity.getTransaction().begin();
			entity.merge(tipo_doc);
			entity.getTransaction().commit();
			
		}

		@Override
		public void eliminarTipoDoc(int idDoc) {
			Tipo_doc alq = new Tipo_doc();
			alq = entity.find(Tipo_doc.class, idDoc);
			entity.getTransaction().begin();
			entity.remove(alq);
			entity.getTransaction().commit();
			
			
		}
			
}