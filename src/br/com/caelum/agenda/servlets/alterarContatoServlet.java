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
 * Servlet implementation class alterarContatoServlet
 */
@WebServlet(urlPatterns = {"/alterarContato"})
public class alterarContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		DaoContato dao = new DaoContato();
		try {
			List<Contato> contatos = dao.getList();
			var contatoSelecionado = contatos.stream().filter(c -> c.getId() == id ).findFirst();
			if(contatoSelecionado.isPresent()) {
				req.setAttribute("contato", contatoSelecionado.get());
			}else {
				req.setAttribute("mesagemErro", "Esse contato não existe.");
				resp.sendRedirect("/AdicionarContato");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());
			resp.sendRedirect("/AdicionarContato");
		}
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/alterarContato.jsp");
		dispatcher.forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contato contatoAlterado = new Contato();
		contatoAlterado.setNome(req.getParameter("nome"));
		contatoAlterado.setEmail(req.getParameter("email"));
		contatoAlterado.setEndereco(req.getParameter("endereco"));
		contatoAlterado.setDataNascimento(req.getParameter("dataNascimento"));
		contatoAlterado.setId(Integer.parseInt(req.getParameter("id")));
		DaoContato dao = new DaoContato(); 
		try {
			dao.atualizar(contatoAlterado);
		} catch (ClassNotFoundException | SQLException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());
		}
		resp.sendRedirect(req.getContextPath()+ "/AdicionarContato");
		
	}

}
