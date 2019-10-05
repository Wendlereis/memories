package br.com.verity.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.soap.InitParam;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	name = "servlet-helloworld", 
	urlPatterns = {"/helloworld"},
	initParams = {
		@WebInitParam(
			name = "param01",
			value = "value do parametro 1"
		),
		@WebInitParam(
			name = "param02",
			value = "value do parametro 2"
		)
	}
)
public class HelloWorld extends HttpServlet{
	private String parametro1;
	private String parametro2;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletConfig servletConfig = getServletConfig();
		
		String parametro1 = servletConfig.getInitParameter("param01");
		out.println(parametro1);
		
		String parametro2 = servletConfig.getInitParameter("param02");
		out.println(parametro2);
		
		out.close();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		parametro1 = config.getInitParameter("param01");
		parametro1 = config.getInitParameter("param02");
	}
}
