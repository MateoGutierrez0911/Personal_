package com.mateo.artemisa.app.fachadaimp;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JTextField;

import org.hibernate.Session;

import com.mateo.artemisa.app.fachada.ILogin;
import com.mateo.artemisa.app.modelo.Login;
import com.mateo.artemisa.app.modelo.Usuarios;
import com.mateo.artemisa.app.util.JPAUtil;

public class Loginimp implements ILogin {
	private Session sessions;

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();	
	@Override
	public void ValidacionLogin(Login login) {
		// TODO Auto-generated method stub
		
		
		
	


}
}