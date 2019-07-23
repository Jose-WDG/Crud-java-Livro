package br.com.caelum.agenda.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.Dao.DaoContato;
import br.com.caelum.agenda.entidades.Contato;

/**
 * Servlet implementation class excluirContato
 */
@WebServlet("/excluirContato")
public class excluirContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idContato = Integer.parseInt(req.getParameter("id"));
		Contato contatoExcluido = new Contato();
		contatoExcluido.setId(idContato);
		DaoContato dao = new DaoContato();
		
		try {
			dao.excluir(contatoExcluido);
		} catch (SQLException | ClassNotFoundException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());
		}
		resp.sendRedirect(req.getContextPath()+"/AdicionarContato");
	}

}
