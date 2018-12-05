package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String datarecieved1 = (String) request.getAttribute("D1");
		String datarecieved2 = (String) request.getSession().getAttribute("D2");
		String datarecieved3 = (String) request.getServletContext().getAttribute("D3");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Scope </h2>");
		out.println("<h3> Data - D1 :"+datarecieved1+"</h3>");
		out.println("<h3> Data - D2 :"+datarecieved2+"</h3>");
		out.println("<h3> Data - D3 :"+datarecieved3+"</h3>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
