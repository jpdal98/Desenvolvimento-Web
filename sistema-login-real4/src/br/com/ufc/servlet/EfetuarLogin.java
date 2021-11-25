package br.com.ufc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ufc.dao.PessoaDAO;
import br.com.ufc.model.Pessoa;

@WebServlet("/efetuarLogin")
public class EfetuarLogin extends HttpServlet{
	private PessoaDAO pessoaDAO = new PessoaDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("username");
		String senha = request.getParameter("password");
		
		Pessoa pessoa = pessoaDAO.buscarUsuario(nome,senha);
		
		
		HttpSession sessao = request.getSession();
		
		if(pessoa!= null) {
			sessao.setAttribute("usuarioLogado",nome);
			response.sendRedirect("paginaInicial");
			
		}
		
		else {
			response.sendRedirect("loginForm");
			
			
			//mandar a página de form de novo
		}
		
	}
	
	
	
}
