package com.ufc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ufc.model.Pessoa;

import comufc.dao.PessoaDAO;

@WebServlet("/efetuarLogin")
public class AutenticarUsuario extends HttpServlet{
	
	private PessoaDAO pessoaDAO = new PessoaDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String senha = request.getParameter("senha");
		
		Pessoa pessoa = pessoaDAO.autenticar(username,senha);
		HttpSession sessao = request.getSession();
		
		if(pessoa!= null) {
			sessao.setAttribute("usuarioLogado", username);
			response.sendRedirect("paginaInicial");
		}
		
		else {
			response.sendRedirect("loginFormulario");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
