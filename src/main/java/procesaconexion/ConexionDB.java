package procesaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {
    protected Connection conn = null;

    // Método para generar conexión directa a PostgreSQL
    protected Connection generaConexion() {
        String usr = "postgres";        // Usuario de PostgreSQL
        String pwd = "1234";           // Contraseña de PostgreSQL
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/horoscopo"; // Nombre de tu base de datos

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usr, pwd);
            System.out.println("Conexión establecida exitosamente");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    // Método para cerrar la conexión
    protected void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexión cerrada exitosamente");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}