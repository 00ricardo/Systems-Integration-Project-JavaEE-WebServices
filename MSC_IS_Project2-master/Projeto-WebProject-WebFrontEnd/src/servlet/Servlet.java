package servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Publication;
import ejb.SessionBeanPublications;
import serv.PublicationsSoap;
import serv.PublicationsSoapProxy;



/**
 * Servlet implementation class Servlet
 */
@WebServlet("/")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//all publications
		List<Publication> publications = new ArrayList<Publication>();
		
		// Service Publications
		PublicationsSoapProxy proxyPublication = new PublicationsSoapProxy();
		PublicationsSoap servicePublication = proxyPublication.getPublicationsSoap();
		byte[] arrPublications = null;
		arrPublications = servicePublication.getAllPublications();
		// Deserialize the List of Publications
				if (arrPublications != null) {
					ByteArrayInputStream in = new ByteArrayInputStream(arrPublications);
					ObjectInputStream is;
					try {
						is = new ObjectInputStream(in);
						try {
							publications = (List<Publication>) is.readObject();
						} catch (ClassNotFoundException e) {
							// e.printStackTrace();
							System.out.println("Error in the Desearialize of the publication list - Class Not Found Exeception");
						}
					} catch (IOException e) {
						// e.printStackTrace();
						System.out.println("Error in the Desearialize of the publication list - IO Exception");
					}
				}
		
		//variables
		request.setAttribute("publications", publications);

		//display html
		request.getRequestDispatcher("/display.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
