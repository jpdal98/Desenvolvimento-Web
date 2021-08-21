package br.com.ufc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufc.dao.PessoaDAO;
import br.com.ufc.model.Pessoa;

@WebServlet("/adicionaPessoa")
public class AdicionaPessoa extends HttpServlet{
	
	private PessoaDAO pessoaDAO = new PessoaDAO();
	private List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String time = request.getParameter("time");

		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setTime(time);
		
		pessoaDAO.cadastrarPessoa(pessoa);
		listaPessoas = pessoaDAO.retornarLista();
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Olá mundo");
		out.println("</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("Pessoa com o nome: "+ pessoa.getNome() + "foi cadastrado com sucesso");
		
		
		out.println("---- Pessoas cadastradas no banco -----");

		for (Pessoa pessoa2 : listaPessoas) {
			out.println("Pessoa: " + pessoa2.getNome());
			out.println("Time: " + pessoa2.getTime());
			
		}
		
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		//Pegar os valores do form
		//Criar o objeto pessoa com os valores
		//Salvar no Banco de dados
	}
}
