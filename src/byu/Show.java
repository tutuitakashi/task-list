package byu;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Task;
import utils.DBUtil;

/**
 * Servlet implementation class Show
 */
@WebServlet(name = "show", urlPatterns = { "/show" })
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 EntityManager em = DBUtil.createEntityManager();
		 
		 Task m = em.find(Task.class, Integer.parseInt(request.getParameter("id")));
		 em.close();
		 
		 request.setAttribute("task", m);
		 
		 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/tasks/show.jsp");
		 rd.forward(request, response);
	}

}
