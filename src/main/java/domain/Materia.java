package domain;

import java.util.ArrayList;
import java.util.List;

// Clase Materia
public class Materia {
    private String nombre;
    private String codigo;
    private List<Materia> correlatividades;

    public Materia(String nombre, String codigo, List<Materia> materiasCorrelativas) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.correlatividades = materiasCorrelativas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Materia> getCorrelatividades() {
        return correlatividades;
    }

    public void agregarCorrelatividad(Materia materia) {
        if (!this.correlatividades.contains(materia)) {
            this.correlatividades.add(materia);
        }
    }

    public List<Materia> getMateriasCorrelativas() {
        return correlatividades;
    }
}
