package database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/consulta")
public class ConsultaController extends HttpServlet {

	private String valor(HttpServletRequest req, String param, String padrao) {
		String result = req.getParameter(param);
		if (result == null) {
			result = padrao;
		}
		return result;
	}

	private int toInt(HttpServletRequest req, String param, String padrao) {
		return Integer.parseInt(valor(req, param, padrao));
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = toInt(req, "id", "0");

		List<Perfume> perfumes = null;
		try {
			perfumes = PerfumeDao.consultar(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("lista-perfumes", perfumes);
		
		req.getRequestDispatcher("ConsultaView.jsp").forward(req, resp);
	}
}

