package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.service.to.EstudianteTo;

public interface IEstudianteService {
    
    public EstudianteTo buscarPorId(Integer id);
    public void guardar(EstudianteTo estudiante);
    public List<EstudianteTo> buscarTodos();
    public List<EstudianteTo> buscarPorNombre(String nombre);
    public List<EstudianteTo> buscarPorNombreEdad(String nombre, Integer edad);
    public void actualizar(EstudianteTo estudiante);
    public void borrar(Integer id);
}
