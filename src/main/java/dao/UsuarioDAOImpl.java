package dao;

import modelo.Usuario;
import procesaconexion.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl extends ConexionDB implements UsuarioDAO {
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public Usuario login(String username, String password) {
        Usuario usuario = null;
        String consultaSql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        Connection conn = generaConexion();

        try {
            pstm = conn.prepareStatement(consultaSql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setUsername(rs.getString("username"));
                usuario.setEmail(rs.getString("email"));
                usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                usuario.setPassword(rs.getString("password"));
                usuario.setAnimal(rs.getString("animal"));
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
        return usuario;
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        String consultaSql = "INSERT INTO usuarios (nombre, username, email, fecha_nacimiento, password, animal) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = generaConexion();

        try {
            pstm = conn.prepareStatement(consultaSql);
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getUsername());
            pstm.setString(3, usuario.getEmail());
            pstm.setDate(4, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            pstm.setString(5, usuario.getPassword());
            pstm.setString(6, usuario.getAnimal());

            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        String consultaSql = "UPDATE usuarios SET nombre=?, username=?, email=?, fecha_nacimiento=?, password=?, animal=? WHERE id=?";
        Connection conn = generaConexion();

        try {
            pstm = conn.prepareStatement(consultaSql);
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getUsername());
            pstm.setString(3, usuario.getEmail());
            pstm.setDate(4, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            pstm.setString(5, usuario.getPassword());
            pstm.setString(6, usuario.getAnimal());
            pstm.setInt(7, usuario.getId());

            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void eliminarUsuario(Integer id) {
        String consultaSql = "DELETE FROM usuarios WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = generaConexion();
            pstm = conn.prepareStatement(consultaSql);
            pstm.setInt(1, id);
            System.out.println("holaaaaaaa");
            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Usuario eliminado correctamente. Filas afectadas: " + rowsAffected);
            } else {
                System.out.println("No se encontró ningún usuario con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión o la sentencia: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String consultaSql = "SELECT * FROM usuarios";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        System.out.println( "Dios mio ayudame");
        try {
            conn = generaConexion();
            System.out.println("Conexión establecida para listar usuarios");

            pstm = conn.prepareStatement(consultaSql);
            System.out.println("Ejecutando consulta: " + consultaSql);

            rs = pstm.executeQuery();
            System.out.println("Consulta ejecutada, procesando resultados");

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setUsername(rs.getString("username"));
                usuario.setEmail(rs.getString("email"));
                usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                usuario.setPassword(rs.getString("password"));
                usuario.setAnimal(rs.getString("animal"));
                usuarios.add(usuario);

                System.out.println("Usuario agregado a la lista - ID: " + usuario.getId() +
                        ", Nombre: " + usuario.getNombre());
            }

            System.out.println("Total de usuarios encontrados: " + usuarios.size());

        } catch (SQLException e) {
            System.out.println("Error en listarUsuarios: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
                System.out.println("Conexiones cerradas correctamente");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }

    @Override
    public Usuario buscarUsuario(Integer id) {
        Usuario usuario = null;
        System.out.println("usuario");
        String consultaSql = "SELECT * FROM usuarios WHERE id = ?";
        Connection conn = generaConexion();

        try {
            pstm = conn.prepareStatement(consultaSql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            System.out.println("buscar usuario");

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setUsername(rs.getString("username"));
                usuario.setEmail(rs.getString("email"));
                usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                usuario.setPassword(rs.getString("password"));
                usuario.setAnimal(rs.getString("animal"));
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
        return usuario;
    }
}