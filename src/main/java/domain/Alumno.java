package domain;

import java.util.ArrayList;
import java.util.List;

// Clase Alumno
public class Alumno {
    private String nombre;
    private String apellido;
    private int legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido, int legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public boolean aprobado(Materia materia) {
        return materiasAprobadas.contains(materia);
    }
}
