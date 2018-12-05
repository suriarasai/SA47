package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MentorDAO;
import dao.MentorDAOImpl;
import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Mentor;
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
		// TODO Auto-generated method stub
		processRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);

	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getPathInfo();
		StudentDAO sdao = new StudentDAOImpl();
		MentorDAO mdao = new MentorDAOImpl();
		switch (command) {
		case "/load":
			ArrayList<Student> list = sdao.findAll();
			request.setAttribute("students", list);
			RequestDispatcher rd = request.getRequestDispatcher("/StudentCRUD.jsp");
			rd.forward(request, response);
			break;
		case "/process":
			ArrayList<Student> studentList = new ArrayList<Student>();
			String insert = request.getParameter("insert");
			//System.out.println("Insert falg " + insert);
			if (insert.equalsIgnoreCase("true")) {
				Mentor m = mdao.findByID(Integer.parseInt(request.getParameter("mid")));
				Student su = new Student(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),
						request.getParameter("nick"), m);
				sdao.createStudent(su);
				studentList = sdao.findAll();
				request.setAttribute("students", studentList);
				RequestDispatcher rd1 = request.getRequestDispatcher("/StudentCRUD.jsp");
				rd1.forward(request, response);
			} else {
				//Mentor m = new Mentor(1, "SURIA", "Naggy");
				Mentor m = mdao.findByID(Integer.parseInt(request.getParameter("mid")));
				Student su = new Student(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),
						request.getParameter("nick"), m);
				sdao.updateStudent(su);
				studentList = sdao.findAll();
				request.setAttribute("students", studentList);
				RequestDispatcher rd1 = request.getRequestDispatcher("/StudentCRUD.jsp");
				rd1.forward(request, response);
			}
			break;
		case "/delete":
			sdao.removeStudent(Integer.parseInt(request.getParameter("id")));
			studentList = sdao.findAll();
			request.setAttribute("students", studentList);
			RequestDispatcher rd1 = request.getRequestDispatcher("/StudentCRUD.jsp");
			rd1.forward(request, response);

			break;
		default:
			break;
		}

	}
}
