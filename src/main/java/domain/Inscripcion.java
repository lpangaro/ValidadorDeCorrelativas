package domain;

import java.util.List;

// Clase Inscripcion
public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public boolean aprobada() {
        // La inscripción se rechaza si al menos una materia no cumple con sus correlatividades
        for (Materia materia : materias) {
            if (materia.getMateriasCorrelativas() != null) {
                for (Materia correlativa : materia.getMateriasCorrelativas()) {
                    if (!alumno.aprobado(correlativa)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}