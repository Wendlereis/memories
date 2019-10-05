package br.com.verity.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.verity.agenda.bean.Contato;
import br.com.verity.agenda.dao.ContatoDAO;

@WebServlet(
	name = "adicionaContato",
	urlPatterns = {"/adicionaContato"}
)
public class AdicionaContatoServlet extends HttpServlet {
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataNascimento = request.getParameter("datanascimento");
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date date = new Date(dateformat.parse(dataNascimento).getTime());
			
			Contato contato = new Contato(nome, email, endereco, date);
			
			ContatoDAO contatoDao = new ContatoDAO();
			contatoDao.inserirContato(contato);
			
			out.println("<html>");
	        out.println("<body>");
	        out.println("Contato " + contato.getNome() + " adicionado com sucesso");    
	        out.println("</body>");
	        out.println("</html>");
		}
		catch (Exception e) {
			System.out.println("Erro ao Inserir: " + e);
		}
	}
}
