package uce.edu.web.api.service;

import java.util.List;
import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.modelo.IPersonaRepository;
import uce.edu.web.api.repository.modelo.Persona;
import uce.edu.web.api.service.to.PersonaTo;

@ApplicationScoped
public class PersonaServiceImpl implements IPersonaService {
    @Inject
    private IPersonaRepository ipersonaRepository;
    
    private Function<Persona, PersonaTo> mapTo = p -> {
        PersonaTo pTo = new PersonaTo(p.getId(), p.getNombre(), p.getApellido(), p.getFechaNacimiento());
        return pTo;
    };
    
    private Function<PersonaTo, Persona> mapPersona = pTo -> {
        Persona p = new Persona(pTo.getId(), pTo.getNombre(), pTo.getApellido(), pTo.getFechaNacimiento());
        return p;
    };
    
    @Override
    public PersonaTo buscarPorId(Integer id) {
        Persona per = this.ipersonaRepository.buscarPorId(id);
        return this.mapTo.apply(per);
    }


    @Override
    public List<PersonaTo> buscarTodos() {
        return this.ipersonaRepository.buscarTodos().stream().map(this.mapTo).toList();
    }

    @Override
    public List<PersonaTo> buscarPorNombre(String nombre) {
        return this.ipersonaRepository.buscarPorNombre(nombre).stream().map(this.mapTo).toList();
    }

    @Override
    public List<PersonaTo> buscarPorNombreApellido(String nombre, String apellido) {
        return this.ipersonaRepository.buscarPorNombreApellido(nombre, apellido).stream().map(this.mapTo).toList();
    }

    @Override
    public void guardar(PersonaTo persona) {
        this.ipersonaRepository.insertar(this.mapPersona.apply(persona));
    }
    @Override
    public void actualizar(PersonaTo persona) {
        Persona per = this.mapPersona.apply(persona);
        this.ipersonaRepository.actualizar(per);
    }
    @Override
    public void borrar(Integer id) {
        this.ipersonaRepository.eliminar(id);
    }    
}