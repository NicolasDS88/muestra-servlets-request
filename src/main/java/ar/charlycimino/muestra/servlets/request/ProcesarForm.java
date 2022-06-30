package ar.charlycimino.muestra.servlets.request;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;



@WebServlet(name = "ProcesarForm", urlPatterns = {"/procesar-form"})
public class ProcesarForm extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String metodoHTTP = request.getMethod();
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Viendo una petición HTTP</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Viendo una petición HTTP</h1>");
            out.print("<p>Observá la información recibida en el objeto 'request' de tipo 'HttpServletRequest' </p>");
            
            out.print("<strong>getProtocol</strong>: " + request.getProtocol());
            out.print("<br>");
            out.print("<strong>getMethod</strong>: " + request.getMethod());
            
            out.print("<hr>");
            
            out.print("<strong>getLocalAddr</strong>: " + request.getLocalAddr());
            out.print("<br>");
            out.print("<strong>getLocalName</strong>: " + request.getLocalName());
            out.print("<br>");
            out.print("<strong>getLocalPort</strong>: " + request.getLocalPort());
            
            out.print("<hr>");
            
            out.print("<strong>getServerName</strong>: " + request.getServerName());
            out.print("<br>");
            out.print("<strong>getServerPort</strong>: " + request.getServerPort());

            out.print("<hr>");
            
            out.print("<strong>getRequestURL</strong>: " + request.getRequestURL());
            out.print("<br>");
            out.print("<strong>getRequestURI</strong>: " + request.getRequestURI());
            out.print("<br>");
            out.print("<strong>getContextPath</strong>: " + request.getContextPath());             
            out.print("<br>");
            out.print("<strong>getServletPath</strong>: " + request.getServletPath());
            out.print("<br>");
            out.print("<strong>getPathInfo</strong>: " + request.getPathInfo()); 
            out.print("<br>");
            out.print("<strong>getQueryString:</strong> " + request.getQueryString());
            
            out.print("<h2>Parámetros</h2>");
            Enumeration params = request.getParameterNames();
            while (params.hasMoreElements()) {
                String nombreDelParametro = (String) params.nextElement();
                out.print("<strong>" + nombreDelParametro + "</strong>: ");
                out.print(request.getParameter(nombreDelParametro));
                out.print("<br>");
            }
            
            out.print("<h2>Headers HTTP</h2>");
            Enumeration cabeceros = request.getHeaderNames();
            while (cabeceros.hasMoreElements()) {
                String nombreDelHeader = (String) cabeceros.nextElement();
                out.print("<strong>" + nombreDelHeader + "</strong>: ");
                out.print(request.getHeader(nombreDelHeader));
                out.print("<br>");
            }

            out.print("<body>");
            out.print("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
