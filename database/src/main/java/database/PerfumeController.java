package database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*

 create table perfume (
 id int,
 nome varchar(255),
 fabricante varchar(255),
 preco varchar(255)
 )

 */
@WebServlet("/perfume")
public class PerfumeController extends HttpServlet {

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

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String msg;
			String op = valor(req, "operacao", "");
			int id = toInt(req, "id", "0");
			String nome = valor(req, "nome", "");
			String fabricante = valor(req, "fabricante", "");
			String preco = valor(req, "preco", "");

			if (op.equals("incluir")) {
				PerfumeDao.inclui(id, nome, fabricante, preco);
				msg = "Inclusão realizada com sucesso.";
			} else if (op.equals("alterar")) {
				PerfumeDao.alterar(id, nome, fabricante, preco);
				msg = "Alteração realizada com sucesso.";
			} else if (op.equals("excluir")) {
				PerfumeDao.excluir(id);
				resp.sendRedirect("perfume");
				msg = "Exclusão realizada com sucesso.";
			} else if (op.equals("")) {
				msg = "";
			} else {
				throw new IllegalArgumentException("Operação \"" + op
						+ "\" não suportada.");
			}

			req.setAttribute("msg", msg);

			List<Perfume> perfumes = PerfumeDao.listar();
			req.setAttribute("lista-perfumes", perfumes);

			req.getRequestDispatcher("PerfumeView.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
}
