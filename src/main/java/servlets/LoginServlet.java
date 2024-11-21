package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import modelo.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    public void init() {
        usuarioDAO = new UsuarioDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Usuario usuario = usuarioDAO.login(username, password);

            if (usuario != null) {

                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);


                response.sendRedirect("consulta-horoscopo.jsp");
            } else {

                request.setAttribute("error", "Usuario o contraseña incorrectos");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {

            request.setAttribute("error", "Error en el sistema. Intente más tarde.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}