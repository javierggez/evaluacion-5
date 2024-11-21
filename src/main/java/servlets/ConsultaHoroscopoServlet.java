package servlets;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HoroscopoDao;
import dao.HoroscopoDAOImpl;
import modelo.Usuario;


@WebServlet("/consulta-horoscopo")
public class ConsultaHoroscopoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HoroscopoDao horoscopoDAO;


    private static class SignoChino {
        String nombre;
        String icono;

        SignoChino(String nombre, String icono) {
            this.nombre = nombre;
            this.icono = icono;
        }
    }

    public void init() {
        horoscopoDAO = new HoroscopoDAOImpl();
    }


    private SignoChino calcularSigno(int año) {
        int resto = año % 12;
        SignoChino[] signos = {
                new SignoChino("Mono", "🐒"),
                new SignoChino("Gallo", "🐓"),
                new SignoChino("Perro", "🐕"),
                new SignoChino("Cerdo", "🐖"),
                new SignoChino("Rata", "🐀"),
                new SignoChino("Buey", "🐂"),
                new SignoChino("Tigre", "🐅"),
                new SignoChino("Conejo", "🐇"),
                new SignoChino("Dragón", "🐉"),
                new SignoChino("Serpiente", "🐍"),
                new SignoChino("Caballo", "🐎"),
                new SignoChino("Cabra", "🐐")
        };
        return signos[resto];
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");


        if (usuario == null) {
            request.setAttribute("error", "Debe iniciar sesión para consultar el horóscopo");
            response.sendRedirect("login.jsp");
            return;
        }

        try {

            Calendar cal = Calendar.getInstance();
            cal.setTime(usuario.getFechaNacimiento());
            int año = cal.get(Calendar.YEAR);


            SignoChino signo = calcularSigno(año);


            usuario.setAnimal(signo.nombre);


            String mensaje = "Según el horóscopo chino, tu animal es: " + signo.nombre;


            request.setAttribute("nombreSigno", signo.nombre);
            request.setAttribute("iconoSigno", signo.icono);  // Usamos signo.icono en lugar de iconoSigno
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("año", año);


            request.getRequestDispatcher("consulta-horoscopo.jsp").forward(request, response);

        } catch (Exception e) {

            String errorMsg = "Error al consultar el horóscopo: " + e.getMessage();
            request.setAttribute("error", errorMsg);
            request.getRequestDispatcher("consulta-horoscopo.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
        horoscopoDAO = null;
    }
}