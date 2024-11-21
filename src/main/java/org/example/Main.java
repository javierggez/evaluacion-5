package org.example;

import dao.HoroscopoDao;
import dao.HoroscopoDAOImpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import modelo.Horoscopo;
import modelo.Usuario;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando aplicación Horóscopo Chino");

        try {
            // Probar conexión a la base de datos
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            HoroscopoDao horoscopoDAO = new HoroscopoDAOImpl();

            // Probar consulta de horóscopos
            System.out.println("Consultando horóscopos...");
            for (Horoscopo h : horoscopoDAO.obtenerHoroscopo()) {
                System.out.println("Animal: " + h.getAnimal() +
                        " - Inicio: " + h.getFecha_inicio() +
                        " - Fin: " + h.getFecha_fin());
            }

            System.out.println("Conexión y consultas realizadas con éxito");

        } catch (Exception e) {
            System.out.println("Error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}