package uce.edu.web.api.repository.modelo;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class EstudianteRepositoryImpl implements IEstudianteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante buscarId(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public List<Estudiante> buscarTodos() {
        TypedQuery<Estudiante> myQuery= this.entityManager.createQuery("SELECT e FROM Estudiante e",Estudiante.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Estudiante> buscarPorNombre(String nombre) {
        TypedQuery<Estudiante> myQuery= this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.nombre =:nombre",Estudiante.class);
        myQuery.setParameter("nombre", nombre);
        return myQuery.getResultList();
    }

    @Override
    public List<Estudiante> buscarPorNombreEdad(String nombre, Integer edad) {
        TypedQuery<Estudiante> myQuery= this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.nombre =:nombre AND e.edad =:edad",Estudiante.class);
        myQuery.setParameter("nombre", nombre);
        myQuery.setParameter("edad", edad);
        return myQuery.getResultList();
    }

    @Override
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.buscarId(id));
    }

    
}
