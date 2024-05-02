package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/CR")
public class ImpostoCR extends HttpServlet implements IImpostoInterface {
	private static final long serialVersionUID = 1L;
       
    public ImpostoCR() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("CalcularSP.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float area = (float)Integer.parseInt(request.getParameter("areaTotal"));
		int idade = Integer.parseInt(request.getParameter("idade"));
		
		double imposto = calcImposto(area, idade);
		
		request.setAttribute("imposto", imposto);
		
		RequestDispatcher rd = request.getRequestDispatcher("CalcularSP.jsp");
		rd.forward(request, response);
	}

	@Override
	public double calcImposto(float v1, double v2) {
		if(v2 < 20) {
			return (double)((v1 * 5)+(v2 * 2));
		}else {
			if(v2 > 50) {
				return (double)((v1 * 5)+(v2 * 3));
			}else {
				return (double)((v1 * 5)+(v2 * 2.5));
			}
		}
	}

}
