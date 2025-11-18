package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.UsuarioDAO;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("username");
		String pass = request.getParameter("senha");
		
		UsuarioDAO dao = new UsuarioDAO();
		boolean sucesso = dao.cadastrarUsuario(nome, pass);
		
		
		if(sucesso) {
			
			request.setAttribute("mensagem", "Usuário cadastrado com sucesso! Faça login.");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			
			request.setAttribute("mensagem", "Erro ao cadastrar. Tente outro nome de usuário.");
			request.getRequestDispatcher("Cadastro.jsp").forward(request, response);
		}
	}
}