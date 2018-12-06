package sample.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.model.HeroDTO;
import sample.service.HeroManager;

/**
 * Servlet implementation class for Servlet: ProcessServlet
 *
 */
@WebServlet("/process")
 public class ProcessServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ProcessServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}   	  	   
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		HeroManager hm = new HeroManager();
		HeroDTO hero = new HeroDTO();
		hero.setName(request.getParameter("name"));
		hero.setDescription(request.getParameter("description"));
		hero.setPlay(request.getParameter("play"));
		String ins = (String) request.getParameter("ins");
		Logger.getLogger(getClass().getName()).log(Level.INFO,
				"Insert Flag: " + ins);
		System.out.println("MESSAGE");
		if (ins.equalsIgnoreCase("true")) {
			hm.insertHero(hero);
		} else {
			hm.updateHero(hero);
		}
		ArrayList<HeroDTO> data = hm.findAllHero();
		request.setAttribute("heros", data);
		RequestDispatcher rd = request.getRequestDispatcher("/views/CRUDPage.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}