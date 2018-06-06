import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.DAOUsuario;
import DBO.DBOUsuario;
import java.math.BigInteger;
import java.security.MessageDigest;


public class Login extends HttpServlet {

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
        try
        {
            
            response.setContentType("text/html;charset=UTF-8");
            DBOUsuario usr = DAOUsuario.getUsuario(request.getParameter("email"));
            if(usr != null)
            {
                String senha = request.getParameter("senha");
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(senha.getBytes(), 0, senha.length());
                senha = (new BigInteger(1,md.digest()).toString(32)).toString();
                 
                 if(!usr.getSenha().equals(senha))
                 {
                        try (PrintWriter out = response.getWriter()) {             
                        out.println(
                                    "<!DOCTYPE html>\n" +
                                    "<html>\n" +
                                    "    <head>\n" +
                                    "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                                    "        <title>Pagina de Login</title>\n" +
                                    "    </head>\n" +
                                    "    <body>\n" +
                                    "        <h1>Login</h1>\n" +
                                    "        <form method=\"POST\" action=\"Login\" style=\"border: 2px solid black\">\n" +
                                    "            <span style='color:red;'>Senha incorreta</span><br>" +
                                    "            E-mail:<input type=\"email\" id=\"email\" name=\"email\">\n" +
                                    "            <br>\n" +
                                    "            Senha: <input type=\"password\" id=\"senha\" name=\"senha\">\n" +
                                    "            <br>\n" +
                                    "            <input type=\"submit\" value=\"Logar\">\n" +
                                    "        </form>\n" +
                                    "        <br>\n" +
                                    "         Ainda não tem conta? Crie uma <a href=\"Cadastro.jsp\">aqui</a>\n" +
                                    "    </body>\n" +
                                    "</html>");
                   }
                 }
                 else
                 {
                     response.sendRedirect("Compra.jsp");
                 }
            }
            else
            {
                try (PrintWriter out = response.getWriter()) {
                        
                        out.println(
                                    "<!DOCTYPE html>\n" +
                                    "<html>\n" +
                                    "    <head>\n" +
                                    "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                                    "        <title>Pagina de Login</title>\n" +
                                    "    </head>\n" +
                                    "    <body>\n" +
                                    "        <h1>Login</h1>\n" +
                                    "        <form method=\"POST\" action=\"Login\" style=\"border: 2px solid black\">\n" +
                                    "            <span style='color:red'>Usuário não encontrado</span><br>" +
                                    "            E-mail:<input type=\"email\" id=\"email\" name=\"email\">\n" +
                                    "            <br>\n" +
                                    "            Senha: <input type=\"password\" id=\"senha\" name=\"senha\">\n" +
                                    "            <br>\n" +
                                    "            <input type=\"submit\" value=\"Logar\">\n" +
                                    "        </form>\n" +
                                    "        <br>\n" +
                                    "         Ainda não tem conta? Crie uma <a href=\"Cadastro.jsp\">aqui</a>\n" +
                                    "    </body>\n" +
                                    "</html>");
                }
            }
            

            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
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
        return "Login";
    }// </editor-fold>

}
