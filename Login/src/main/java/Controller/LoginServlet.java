package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.UsuarioDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Pegar os dados da login.jsp
		String username = request.getParameter("username");
		String senha = request.getParameter("senha");
		
		UsuarioDAO dao = new UsuarioDAO();
		
		//Não aceitar dados somente com espaço ou vazio
		if(username == null || username.trim().isEmpty() || senha == null || senha.trim().isEmpty()){
			request.setAttribute("mensagem", "Preencha com usuario e senha válida");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
		//Validação das credenciais
		if(dao.validarLogin(username, senha)){
			response.sendRedirect("Home.jsp");
		}else {
			request.setAttribute("mensagem", "Usuário ou senha incorreto");
		    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		    rd.forward(request, response);
		}
		
	}

}
