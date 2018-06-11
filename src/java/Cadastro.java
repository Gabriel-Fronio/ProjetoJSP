/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import DAO.DAOUsuario;
import DBO.DBOUsuario;
import java.util.Enumeration;

/**
 *
 * @author gabri
 */
@WebServlet(urlPatterns = {"/Cadastro"})
public class Cadastro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nome = request.getParameter("nome") +" "+ request.getParameter("sobrenome");
        String cpf  = request.getParameter("cpf");
        char   sexo = request.getParameter("sexo").charAt(0);
        String data0 = request.getParameter("data");
        String telefone = request.getParameter("telefone");
        String cep = request.getParameter("cep");
        String end = request.getParameter("end") + ", " + request.getParameter("numero") + " (" + request.getParameter("complemento") + ") - " + request.getParameter("bairro") 
                + " - "+ request.getParameter("cidade") + "/" + request.getParameter("uf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Date data = Date.valueOf(data0);
        
        try (PrintWriter out = response.getWriter()) {
            
            if(DAOUsuario.insert(new DBOUsuario(nome, cpf, telefone, cep, end, email, senha, sexo, data)))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Cadastro</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>"+ nome +", você foi cadastrado com sucesso</h1><br>");
                out.println("<a href='index.html'>Voltar</a><br>");
                out.println("<a href='Login.jsp'>Logar</a>");
                out.println("</body>");
                out.println("</html>");
            }
            else
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Cadastro</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>"+ nome +", ocorreu um erro e voce nao pode ser cadastrado</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    /**
     * Handles the HTTP <code>POST</code> method.
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
        return "Sign in";
    }// </editor-fold>

}
