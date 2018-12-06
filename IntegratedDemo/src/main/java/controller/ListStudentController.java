package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

/**
 * Servlet implementation class ListStudentController
 */
@WebServlet("/list")
public class ListStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Student student1 = new Student("Somebody", null, "S1234567K", "sleeping", 100);
		Student student2 = new Student("Nobody", null, "S1234567L", "dreaming", 100);
		Student student3 = new Student("Everybody", null, "S1234567M", "eyes-wide-open-meditating", 100);
		ArrayList<Student> slist = new ArrayList<Student>();
		slist.add(student1); slist.add(student2); slist.add(student3);
		request.setAttribute("slist", slist);
		RequestDispatcher rd = request.getRequestDispatcher("/DisplayStudents.jsp");
		rd.forward(request, response);
		
		
		

	}

}
