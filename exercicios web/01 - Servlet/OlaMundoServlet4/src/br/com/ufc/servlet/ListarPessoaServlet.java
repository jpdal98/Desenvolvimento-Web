package br.com.ufc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufc.dao.PessoaDAO;
import br.com.ufc.model.Pessoa;

@WebServlet("/listarPessoa")
public class ListarPessoaServlet extends HttpServlet{
	
	private PessoaDAO pessoaDAO = new PessoaDAO();
	private List<Pessoa> listaDePessoas;
	
			
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			listaDePessoas = pessoaDAO.retornarLista();
			
			
			
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title> Meu primeiro </title>");
			out.println("</head>");
			
			out.println("<body>");
			
			 for (Pessoa pessoa : listaDePessoas) {
				out.println("Nome: " + pessoa.getNome());
				out.println("Time:" + pessoa.getTime() + "<br>");
			}
			 
			out.println("</body>");
			out.println("</html>");
			
		}
	
	
}
