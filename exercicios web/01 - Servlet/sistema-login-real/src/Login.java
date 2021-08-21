

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.jrockit.jfr.RequestableEvent;

import sun.security.provider.certpath.ResponderId;

/**
 * Servlet implementation class Login
 */
@WebServlet("/efetuarLogin")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.cadastrarPessoas();
		
		Pessoa pessoa = pessoaDAO.buscarPessoa(login, senha);
		
		if(pessoa != null) {
			sessao.setAttribute("usuarioLogado", login);
			//vou mandar ele para a página inicial
			response.sendRedirect("telaInicial");
		}
		else {
			// vou mandar o cara para a página de formulário novamente
			response.sendRedirect("loginForm");
		}
		
		
	}

}
