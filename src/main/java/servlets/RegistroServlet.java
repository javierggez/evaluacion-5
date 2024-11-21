package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import modelo.Usuario;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    public void init() {
        usuarioDAO = new UsuarioDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            
            String nombre = request.getParameter("nombre");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String fechaNacStr = request.getParameter("fechaNacimiento");


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento = sdf.parse(fechaNacStr);


            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setUsername(username);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setFechaNacimiento(fechaNacimiento);


            usuarioDAO.crearUsuario(usuario);


            request.setAttribute("mensaje", "Registro exitoso. Por favor inicie sesión.");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Error en el registro: " + e.getMessage());
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}