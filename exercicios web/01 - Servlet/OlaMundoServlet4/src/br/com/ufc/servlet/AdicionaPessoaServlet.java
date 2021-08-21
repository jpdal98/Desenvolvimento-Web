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

@WebServlet("/adicionaPessoa")
public class AdicionaPessoaServlet extends HttpServlet{
	private PessoaDAO pessoaDAO = new PessoaDAO();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String time = request.getParameter("time");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setTime(time);
		pessoaDAO.cadastrarPessoa(pessoa);
		
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title> Meu primeiro </title>");
		out.println("</head>");
		
		out.println("<body>");
		
		 for (Pessoa pessoa2 : pessoaDAO.retornarLista()) {
				out.println("Nome: " + pessoa2.getNome());
				out.println("Time:" + pessoa2.getTime() + "<br>");
			}
		
		out.println("</body>");
		out.println("</html>");
		
		//Pegar os valores do formulário
		//Criar objeto do tipo Pessoa
		//Cadastrar pessoa e mostrar
	}
	
	
	
}
