package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/PA")
public class ImpostoPA extends HttpServlet implements IImpostoInterface {
	private static final long serialVersionUID = 1L;
       
    public ImpostoPA() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("CalcularPA.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float area = (float)Integer.parseInt(request.getParameter("areaTotal"));
		float areaGaragem = Integer.parseInt(request.getParameter("areaGaragem"));
		
		double imposto = calcImposto(area, areaGaragem);
		
		request.setAttribute("imposto", imposto);
		
		RequestDispatcher rd = request.getRequestDispatcher("CalcularPA.jsp");
		rd.forward(request, response);
	}

	@Override
	public double calcImposto(float v1, double v2) {
		if(v2 > 0) {
			return (double)((v1 * 7.5) + (v2 * 2.5));
		}else {
			return (double)(v1 * 8);
		}
	}

}
