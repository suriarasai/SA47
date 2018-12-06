package sample.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sample.exception.NotFoundException;
import sample.model.User;
import sample.service.UserService;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/login")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authenticate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path;
		String u = request.getParameter("username");
		String p = request.getParameter("password");
		User user = new User();
		user.setName(u);
		user.setPassword(p);
		UserService service;
		boolean result = false;
		try {
		 	 service = new UserService();
	    	 result = service.authenticate(user);
	    	 
	    	 HttpSession session = request.getSession();
	    	 session.setAttribute("profile", user);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		if (result)
			path = "/views/Success.jsp";
		else
			path = "/views/TryAgain.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
