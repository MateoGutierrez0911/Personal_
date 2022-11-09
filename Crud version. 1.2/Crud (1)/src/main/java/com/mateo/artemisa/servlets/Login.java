package com.mateo.artemisa.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mateo.artemisa.app.fachadaimp.Usuarioimp;
import com.mateo.artemisa.app.modelo.Usuarios;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		
		Usuarioimp usuarioimp = new Usuarioimp();
		List<Usuarios> usuarios = usuarioimp.obtenerTodos();
		
		Usuarios usuario = null;
		
		for (Usuarios e: usuarios) {
			if (e.getEmailUsuario().toLowerCase().equals(email) && e.getContraseña().equals(password)) {
				usuario = e;
				break;
			}
		}
		
		if (usuario != null) {
	        response.sendRedirect("http://localhost:8080/Crud/faces/Usuarios.xhtml");
		} else {
			response.sendRedirect("http://localhost:8080/Crud/faces/Index.html");
		}
	}

}
