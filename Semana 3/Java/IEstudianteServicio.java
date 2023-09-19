package utn.estudiantes.servicios;

import java.util.List;
import utn.estudiantes.modelo.Estudiante;

public interface IEstudianteServicio {
    List<Estudiante> listarEstudiantes();
    Estudiante buscarEstudiante(Long id);
    void guardarEstudiante(Estudiante estudiante);
    void eliminarEstudiante(Long id);
    void modificarEstudiante(Estudiante estudiante);
}
