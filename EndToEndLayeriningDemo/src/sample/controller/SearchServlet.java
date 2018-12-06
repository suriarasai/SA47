package sample.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.model.HeroDTO;
import sample.model.HeroSearchDTO;
import sample.service.HeroManager;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nm = request.getParameter("name");
		String des = request.getParameter("description");
		if (nm.trim().equalsIgnoreCase("")&&des.trim().equalsIgnoreCase("")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/SearchPage.jsp");
			rd.forward(request, response);
		} else {
			HeroSearchDTO hso = new HeroSearchDTO();
			hso.setName(nm);
			hso.setDescription(des);
			HeroManager hm = new HeroManager();
			ArrayList<HeroDTO> herolist = hm.findHerosByCriteria(hso);
			request.setAttribute("searchlist", herolist);
			RequestDispatcher rd = request.getRequestDispatcher("/views/SearchPage.jsp");
			rd.forward(request, response);
		}

	}

}
