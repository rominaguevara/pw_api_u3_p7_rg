package uce.edu.web.api.repository.modelo;

import uce.edu.web.api.repository.modelo.Persona;

public interface IPersonaRepository {

    public Persona burcarPorId(Integer id);

    public void insertar(Persona persona);

    public void actualizar(Persona persona);

    public void eliminar(Integer id);
}
