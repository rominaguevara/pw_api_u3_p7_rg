package uce.edu.web.api.repository.modelo;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class PersonaRepositoryImpl implements IPersonaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Persona buscarPorId(Integer id) {
        try {
            return this.entityManager.find(Persona.class, id);
        } catch (Exception e) {
            System.out.println("Error: ID no válido.");
            return null;
        } 
        
    }

    @Override
    public List<Persona> buscarTodos() {
        TypedQuery<Persona> myQuery = this.entityManager.createQuery("SELECT p FROM Persona p", Persona.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Persona> buscarPorNombre(String nombre) {
        TypedQuery<Persona> myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre =:nombre",
                Persona.class);
        myQuery.setParameter("nombre", nombre);
        return myQuery.getResultList();
    }

    @Override
    public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
        TypedQuery<Persona> myQuery = this.entityManager.createQuery(
                "SELECT p FROM Persona p WHERE p.nombre =:nombre AND p.apellido =:apellido", Persona.class);
        myQuery.setParameter("nombre", nombre);
        myQuery.setParameter("apellido", apellido);
        return myQuery.getResultList();
    }

    @Override
    public void insertar(Persona persona) {
        this.entityManager.persist(persona);
    }

    @Override
    public void actualizar(Persona persona) {
        this.entityManager.merge(persona);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.buscarPorId(id));
    }

}