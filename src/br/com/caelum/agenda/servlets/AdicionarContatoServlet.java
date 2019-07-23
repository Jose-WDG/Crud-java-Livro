package br.com.caelum.agenda.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.Dao.DaoContato;
import br.com.caelum.agenda.entidades.Contato;

/**
 * Servlet implementation class AdicionarContatoServlet
 */
@WebServlet(urlPatterns = {"/AdicionarContato"})

public class AdicionarContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoContato contatos = new DaoContato();
		try {
			List<Contato> contato = contatos.getList();
			req.setAttribute("listaContatos", contato);
		} catch (SQLException e) {
			req.setAttribute("mensagemErro", e.getMessage());
		} catch (ClassNotFoundException e) {
			req.setAttribute("mensagemErro", e.getMessage());
		}
		Object mensagemErro = req.getSession().getAttribute("mensagemErro");
		if (mensagemErro != null) {
			req.setAttribute("mensagemErro", mensagemErro.toString());
			req.getSession().removeAttribute("mensagemErro");
		}
		RequestDispatcher dispatcher = req.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/adicionaContato.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		try {
			// monta um objeto contato
			Contato contato = new Contato();
			DaoContato dao = new DaoContato();

			contato.setNome(req.getParameter("nome"));
			contato.setEndereco(req.getParameter("endereco"));
			contato.setDataNascimento(req.getParameter("dataNascimento"));
			if (dao.validaEmail(req.getParameter("email"))){
				contato.setEmail(req.getParameter("email"));
			}
				
			// salva o contato
			dao.inserir(contato);
		} catch (SQLException e) {
			System.out.println("esse email já esta sendo usado: \nErro: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}

		resp.sendRedirect(req.getContextPath() + "/AdicionarContato");

	}

}
