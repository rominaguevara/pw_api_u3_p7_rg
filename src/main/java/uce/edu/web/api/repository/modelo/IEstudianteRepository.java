package uce.edu.web.api.repository.modelo;

public interface IEstudianteRepository {

    public Estudiante buscarId(Integer id);

    public void insertar(Estudiante estudiante);

    public void actualizar(Estudiante estudiante);

    public void eliminar(Integer id);

}
