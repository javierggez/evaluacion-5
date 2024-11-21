package dao;

import modelo.Horoscopo;
import procesaconexion.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoroscopoDAOImpl extends ConexionDB implements HoroscopoDao {
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    // Mapa de íconos para cada animal
    public String obtenerIcono(String animal) {
        switch(animal) {
            case "Mono": return "🐒";
            case "Gallo": return "🐓";
            case "Perro": return "🐕";
            case "Cerdo": return "🐖";
            case "Rata": return "🐀";
            case "Buey": return "🐂";
            case "Tigre": return "🐅";
            case "Conejo": return "🐇";
            case "Dragón": return "🐉";
            case "Serpiente": return "🐍";
            case "Caballo": return "🐎";
            case "Cabra": return "🐐";
            default: return "❓";
        }
    }

    @Override
    public List<Horoscopo> obtenerHoroscopo() {
        List<Horoscopo> horoscopo = new ArrayList<>();
        String consultaSql = "SELECT * FROM horoscopo";
        Connection conn = generaConexion();

        try {
            pstm = conn.prepareStatement(consultaSql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                String animal = rs.getString("animal");
                Horoscopo h = new Horoscopo(
                        animal,
                        obtenerIcono(animal),  // Obtener el ícono correspondiente
                        rs.getDate("fecha_inicio"),
                        rs.getDate("fecha_fin")
                );
                horoscopo.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return horoscopo;
    }
}