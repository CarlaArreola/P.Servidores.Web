package mx.ulsa.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import mx.ulsa.modelo.Usuario;

public class LoginControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginControlador() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		procesar(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		
		String action = request.getPathInfo(); //ingresar
		System.out.println("action: " + action);
		switch(action) 
		{
		case "/login" -> login(request, response);
		case "/ingresar" -> ingresar(request, response);
		case "/logout" -> logout(request, response);
		default -> response.sendRedirect(request.getContextPath() + "/index.jsp");
		} 
		}
		catch (Exception e ) 
		{
		e.printStackTrace();
		}
	}
	
	private Object logout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void login (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		
		String email = "";
		Cookie[] cookies = request.getCookies();
		if(cookies!=null)
		{
			for(int i=0;i<cookies.length;i++)
			{
				Cookie cookie = cookies[i];
				if(cookie.getName().equals("correo"))
				{
					System.out.print("Correo cookie" + cookie.getValue());
					email = cookie.getName();
				}
			}
		}
		response.sendRedirect(request.getContextPath() + "/vista/login.jsp");
	}
	
	private Object ingresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String email = request.getParameter("email");
		//String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(email + " " + password);
		
		
		Usuario usuario = new Usuario(email,password);
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		if(usuario.isValidEmail()) {
			Cookie cookie = new Cookie("correo", email);
			cookie.setMaxAge(120); //TIEMPO DE VIDA DE LA COOKIE EN EL NAVEGADOR
			response.addCookie(cookie);
			response.sendRedirect(request.getContextPath() + "/vista/privado/panel.jsp?email="+email);
		} else {
			request.setAttribute("errorMessage", "Usuario o contraseña incorrectos");
			request.getRequestDispatcher("vista/login.jsp").forward(request, response);
		}
		
		return null;
	}
		
		

}
