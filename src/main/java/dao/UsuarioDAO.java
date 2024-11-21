package dao;

import modelo.Usuario;
import java.util.List;

public interface UsuarioDAO {
    Usuario login(String username, String password);
    void crearUsuario(Usuario usuario);
    void modificarUsuario(Usuario usuario);
    void eliminarUsuario(Integer id);
    List<Usuario> listarUsuarios();
    Usuario buscarUsuario(Integer id);
}