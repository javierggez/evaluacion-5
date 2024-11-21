package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import modelo.Usuario;

@WebServlet("/listar-usuarios")
public class ListarUsuariosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    public void init() {
        usuarioDAO = new UsuarioDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            List<Usuario> usuarios = usuarioDAO.listarUsuarios();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("listar-usuarios.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error al listar usuarios: " + e.getMessage());
            request.getRequestDispatcher("listar-usuarios.jsp").forward(request, response);
        }
    }
}
