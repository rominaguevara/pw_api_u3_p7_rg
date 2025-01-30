package uce.edu.web.api.repository.modelo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class PersonaRepositoryImpl implements IPersonaRepository{
    
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void actualizar(Persona persona) {
        this.entityManager.merge(persona);
    }

    @Override
    public Persona burcarPorId(Integer id) {
        this.entityManager.find(Persona.class, id);
        return null;
    }

    @Override
    public void insertar(Persona persona) {
        this.entityManager.persist(persona);        
    }

    

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.burcarPorId(id));        
    }

    

    
}
