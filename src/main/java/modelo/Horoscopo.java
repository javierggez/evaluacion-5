package modelo;

import java.util.Date;

public class Horoscopo {
    private String animal;
    private String icono;  // Nuevo campo para el ícono
    private Date fecha_inicio;
    private Date fecha_fin;

    // Constructor vacío
    public Horoscopo() {
    }

    // Constructor con parámetros original
    public Horoscopo(String animal, Date fecha_inicio, Date fecha_fin) {
        this.animal = animal;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    // Nuevo constructor incluyendo ícono
    public Horoscopo(String animal, String icono, Date fecha_inicio, Date fecha_fin) {
        this.animal = animal;
        this.icono = icono;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    // Getters y Setters originales
    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    // Nuevos getter y setter para ícono
    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @Override
    public String toString() {
        return "Horoscopo{" +
                "animal='" + animal + '\'' +
                ", icono='" + icono + '\'' +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                '}';
    }
}