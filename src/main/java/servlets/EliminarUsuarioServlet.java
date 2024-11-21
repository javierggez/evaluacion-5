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
@WebServlet("/eliminar-usuario")
public class EliminarUsuarioServlet extends HttpServlet {
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
            System.out.println("ssssssss");

            int id = Integer.parseInt(request.getParameter("id"));
            Usuario usuario = usuarioDAO.buscarUsuario(id);

            if (usuario != null) {
                usuarioDAO.eliminarUsuario(id);
                response.sendRedirect("listar-usuarios");
                request.setAttribute("usuario", usuario);
               // request.getRequestDispatcher("eliminar-usuario.jsp").forward(request, response);
                System.out.println("hhhhh");
            } else {
                request.setAttribute("error", "Usuario no encontrado");
                response.sendRedirect("listar-usuarios");
                System.out.println("ffffffff");
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error al preparar la eliminación del usuario: " + e.getMessage());
            response.sendRedirect("listar-usuarios");
            System.out.println("ddddd");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            usuarioDAO.eliminarUsuario(id);
            request.setAttribute("mensaje", "Usuario eliminado exitosamente");
            response.sendRedirect("listar-usuarios");
        } catch (Exception e) {
            request.setAttribute("error", "Error al eliminar usuario: " + e.getMessage());
           // request.getRequestDispatcher("eliminar-usuario.jsp").forward(request, response);
        }
    }
}