package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import modelo.Usuario;

@WebServlet("/modificar-usuario")
public class ModificarUsuarioServlet extends HttpServlet {
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
            int id = Integer.parseInt(request.getParameter("id"));
            Usuario usuario = usuarioDAO.buscarUsuario(id);

            if (usuario != null) {
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("modificar-usuario.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Usuario no encontrado");
                response.sendRedirect("listar-usuarios.jsp");
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error al cargar el usuario: " + e.getMessage());
            response.sendRedirect("listar-usuarios.jsp");
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
            String nombre = request.getParameter("nombre");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String fechaNacStr = request.getParameter("fechaNacimiento");


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento = sdf.parse(fechaNacStr);


            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setNombre(nombre);
            usuario.setUsername(username);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setFechaNacimiento(fechaNacimiento);


            usuarioDAO.modificarUsuario(usuario);


            request.setAttribute("mensaje", "Usuario modificado exitosamente");
            response.sendRedirect("listar-usuarios");

        } catch (Exception e) {
            request.setAttribute("error", "Error al modificar usuario: " + e.getMessage());
            request.getRequestDispatcher("modificar-usuario.jsp").forward(request, response);
        }
    }
}