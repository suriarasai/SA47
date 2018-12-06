package sample.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.model.HeroDTO;
import sample.service.HeroManager;

@WebServlet("/deleteHero")
public class DeleteHeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteHeroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		HeroManager hm = new HeroManager();
		HeroDTO hero = hm.findHero(username);
		System.out.println(hero.toString());
		hm.deleteHero(hero);
		RequestDispatcher rd = request.getRequestDispatcher("/load");
		rd.forward(request, response);
	}
}
