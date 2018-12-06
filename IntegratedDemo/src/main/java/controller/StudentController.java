package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import model.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/student/*")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getPathInfo();
		switch (path) {
		case "/load":
			ArrayList<Student> studentList = new ArrayList<Student>();
			studentList = DAOFactory.getStudentDAO().findAll();
			request.setAttribute("students", studentList);
			RequestDispatcher rd = request.getRequestDispatcher("/StudentCRUD.jsp");
			rd.forward(request, response);

			break;
		case "/process":
			String insert = request.getParameter("ins");
			System.out.println("I falg "+ insert);
			if (insert.equalsIgnoreCase("true")) {
				Student si = new Student(request.getParameter("name"), null, request.getParameter("nric"),
						request.getParameter("nickName"), Integer.parseInt(request.getParameter("mark")));
				DAOFactory.getStudentDAO().createStudent(si);
				studentList = DAOFactory.getStudentDAO().findAll();
				request.setAttribute("students", studentList);
				RequestDispatcher rd1 = request.getRequestDispatcher("/StudentCRUD.jsp");
				rd1.forward(request, response);
			} else {
				Student su = new Student(request.getParameter("name"), null, request.getParameter("nric"),
						request.getParameter("nickName"), Integer.parseInt(request.getParameter("mark")));
				DAOFactory.getStudentDAO().updateStudent(su);
				studentList = DAOFactory.getStudentDAO().findAll();
				request.setAttribute("students", studentList);
				RequestDispatcher rd1 = request.getRequestDispatcher("/StudentCRUD.jsp");
				rd1.forward(request, response);
			}
			break;
		case "/delete":
			DAOFactory.getStudentDAO().removeStudent(request.getParameter("nric"));
			studentList = DAOFactory.getStudentDAO().findAll();
			request.setAttribute("students", studentList);
			RequestDispatcher rd1 = request.getRequestDispatcher("/StudentCRUD.jsp");
			rd1.forward(request, response);

			break;
		default:
			break;
		}

	}

}
