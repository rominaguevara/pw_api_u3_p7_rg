package uce.edu.web.api.service;

import java.util.function.Function;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.repository.modelo.IEstudianteRepository;
import uce.edu.web.api.repository.modelo.Persona;
import uce.edu.web.api.service.to.EstudianteTo;
import uce.edu.web.api.service.to.PersonaTo;

@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {

    @Inject
    private IEstudianteRepository iestudianteRepository;

    private Function<Estudiante, EstudianteTo> mapTo = e -> {
        EstudianteTo estu = new EstudianteTo(e.getId(), e.getNombre(), e.getApellido(), e.getEdad(), e.getSemestre());
        return estu;
    };

    private Function<EstudianteTo, Estudiante> mapEstudiante = e -> {
        Estudiante es = new Estudiante(e.getId(), e.getNombre(), e.getApellido(), e.getEdad(), e.getSemestre());
        return es;
    };

    @Override
    public EstudianteTo buscarPorId(Integer id) {
        Estudiante est = this.iestudianteRepository.buscarId(id);
        return this.mapTo.apply(est);
    }

    @Override
    public void guardar(EstudianteTo estudiante) {
        this.iestudianteRepository.insertar(this.mapEstudiante.apply(estudiante));
    }

    @Override
    public void actualizar(EstudianteTo estudiante) {
        Estudiante estu = this.mapEstudiante.apply(estudiante);
        this.iestudianteRepository.actualizar(estu);
    }

    @Override
    public void borrar(Integer id) {
        this.iestudianteRepository.eliminar(id);
    }

}
