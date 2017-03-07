package Controlador;

import DAO.ConexionBBDD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControladorError extends HttpServlet {
   
    private Connection conexion;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            conexion = ConexionBBDD.init().GetCon();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession(true);
        try {
            ServletContext sc = getServletContext();
            RequestDispatcher rd;

            switch(request.getParameter("submit")){
                case("volver"):{
                    String url=(String) sesion.getAttribute("url");
                    rd = sc.getRequestDispatcher(url);
                        rd.forward(request, response);
                }
                    
                
            }

            rd = sc.getRequestDispatcher("/* Destino. Tiene que empezar con / */");
            rd.forward(request, response);
        } catch (Exception ex) {
            out.println("<h2>CLASE:</h2>" + this.getClass() + "<br><br>");
            out.println("<h2>EXCEPCION:</h2>" + ex.getClass() + "<br><br>");
            out.println("<h2>MENSAJE:</h2>" + ex.getMessage()+ "<br><br>");
            out.println("<h2>TRAZA:</h2><br>");            
            ex.printStackTrace(out);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}