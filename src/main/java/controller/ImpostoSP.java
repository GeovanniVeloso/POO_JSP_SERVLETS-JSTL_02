package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/SP")
public class ImpostoSP extends HttpServlet implements IImpostoInterface {
	private static final long serialVersionUID = 1L;
       
    public ImpostoSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("CalcularSP.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		float area = (float)Integer.parseInt(request.getParameter("areaTotal"));
		int numComodos = Integer.parseInt(request.getParameter("numComodos"));
		
		double imposto = calcImposto(area, numComodos);
		
		request.setAttribute("imposto", imposto);
		
		RequestDispatcher rd = request.getRequestDispatcher("CalcularSP.jsp");
		rd.forward(request, response);
	}

	@Override
	public double calcImposto(float v1, double v2) {
		return (double)((v1 * 10) + (v2 * 2));
	}

}
