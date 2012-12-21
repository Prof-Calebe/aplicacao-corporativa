package exemplo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EJBStatelessServlet", urlPatterns = {"/EJBStatelessServlet"})
public class EJBStatelessServlet extends HttpServlet {

    @EJB
    private EJBExemploInterface ejb;

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

        String s = null, errorMessage = null;
        double d = 0;
        int i = 0;

        try {
            s = request.getParameter("string_value");
            d = Double.parseDouble(request.getParameter("double_value"));
            i = Integer.parseInt(request.getParameter("int_value"));
        } catch (NumberFormatException e) {
            errorMessage = "Algum número informado é inválido!";
        }

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>EJBStatelessServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (errorMessage != null) {
                out.println("<font color=\"red\">");
                out.println("<h1>" + errorMessage + "</h1>");
                out.println("</font>");
                out.println("<a href=\"EJBStateless.jsp\">Voltar</a><br/>");
            } else {
                out.println("<h1>Resultado da execução do EJBStateless</h1>");
                out.println("<p>" + ejb.metodo(d, i, s) + "</p><br/>");
                out.println("<a href=\"index.jsp\">Inicio</a><br/>");
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
