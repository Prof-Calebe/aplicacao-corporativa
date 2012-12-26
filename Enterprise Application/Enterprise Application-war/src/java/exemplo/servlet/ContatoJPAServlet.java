/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.servlet;

import exemplo.jpa.Contato;
import exemplo.jpa.facade.ContatoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@WebServlet(name = "ContatoJPAServlet", urlPatterns = {"/ContatoJPAServlet"})
public class ContatoJPAServlet extends HttpServlet {

    @EJB
    private ContatoFacadeLocal contatoFacade;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContatoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Contatos</h1>");

            out.println("<h2>Cadastrar Contatos</h2>");
            out.println("<form action=\"ContatoServlet\" method=\"post\">");
            out.println("<table>\n<tr>");
            out.println("<td>Nome</td>");
            out.println("<td>Telefone</td>");
            out.println("</tr>\n<tr>");
            out.println("<td><input name=\"nome_value\" type=\"text\" size=\"50\" value=\"nome\"/></td>");
            out.println("<td><input name=\"telefone_value\" type=\"text\" size=\"14\" value=\"5511999999999\"/></td>");
            out.println("</tr>\n</table>");
            out.println("<input name=\"btn_cadastrar\" type=\"submit\" value=\"Cadastrar\"/>\n</form>");
            if (request.getParameter("btn_cadastrar") != null && request.getParameter("btn_cadastrar").equals("Cadastrar")) {
                try {
                    out.println("<font color=\"red\">");
                    Contato c = new Contato(request.getParameter("nome_value"), request.getParameter("telefone_value"));
                    contatoFacade.create(c);
                    out.println("Contato cadastrado com sucesso.");
                } catch (Exception e) {
                    out.println("Erro ao gravar Contato.");
                } finally {
                    out.println("</font>");
                }
            }

            out.println("<h2>Contatos Cadastrados</h2>");
            List<Contato> list = contatoFacade.findAll();
            for (Contato contato : list) {
                out.println(contato + "<br/>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
