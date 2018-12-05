package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YourFirstServlet
 */
@WebServlet("/first")
public class YourFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YourFirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Welcome SA 47 to Java Web </h2>");
		out.println("<h3> Data - name :"+request.getParameter("name")+"</h3>");
		out.println("<h3> Data - color :"+request.getParameter("color")+"</h3>");
		out.println("Yawn Demo Over");
		out.println("Actually not yet - round two exists!!!");
		out.println("</body></html>");
		
	}

}
