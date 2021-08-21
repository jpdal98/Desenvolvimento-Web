package br.com.ufc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufc.dao.PessoaDAO;
import br.com.ufc.model.Pessoa;

@WebServlet("/adicionarPessoa")
public class AdicionaPessoa extends HttpServlet{
	
	private PessoaDAO pessoaDAO;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String time = request.getParameter("time");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setTime(time);
		
		PessoaDAO pessoaDAO = PessoaDAO.getInstance();
		pessoaDAO.cadastrarPessoa(pessoa);
		
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title> Minha servlet </title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("A pessoa " + 
		pessoa.getNome() + "tem o time: " + 
				pessoa.getTime());
		
		
		out.println("Lista:" + pessoaDAO.toString());
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		//Pegar os dados do formulário
		//Criar um objeto Pessoa
		//Cadastrar e Mostrar na tela
	}
	
	

	
	
}
