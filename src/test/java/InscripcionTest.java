import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import domain.Alumno;
import domain.Inscripcion;
import domain.Materia;
import org.junit.Assert;
import org.junit.Test;

public class InscripcionTest {

    @Test
    public void sinCorrelativas() {
        Alumno alumno = new Alumno("Lucas", "Pangaro", 1234);
        List<Materia>materias = new ArrayList<>();
        materias.add(new Materia("Algoritmos", "K3011", null));
        Inscripcion inscripcion = new Inscripcion(alumno, materias);
        Assert.assertTrue(inscripcion.aprobada());
    }
    @Test
    public void correlativasNoAprobadas() {

        Alumno alumno = new Alumno("Nicolas", "Perez", 123);
        List<Materia> materiasAprobadas = new ArrayList<>();
        materiasAprobadas.add(new Materia("Materia1", "K3011", null));
        alumno.setMateriasAprobadas(materiasAprobadas);
        List<Materia> materias = new ArrayList<>();
        List<Materia> correlativas = new ArrayList<>();
        correlativas.add(new Materia("Materia1", "K3011", null)); // aprobada
        correlativas.add(new Materia("Materia2", "K3012", null)); // no está aprobada
        materias.add(new Materia("Materia3", "K3021", correlativas));
        Inscripcion inscripcion = new Inscripcion(alumno, materias);
        Assert.assertFalse(inscripcion.aprobada());
    }

    @Test
    public void correlativasAprobadas() {
        Alumno alumno = new Alumno("Pato", "Bonatti", 123);
        List<Materia> materiasAprobadas = new ArrayList<>();
        materiasAprobadas.add(new Materia("Materia1", "K3321", null));
        materiasAprobadas.add(new Materia("Materia2", "K3012", null));
        alumno.setMateriasAprobadas(materiasAprobadas);
        List<Materia> materias = new ArrayList<>();
        materias.add(new Materia("Materia3", "K3011", materiasAprobadas));
        materias.add(new Materia("Materia4", "K3011", materiasAprobadas));
        Inscripcion inscripcion = new Inscripcion(alumno, materias);
        Assert.assertTrue(inscripcion.aprobada());
    }
}
