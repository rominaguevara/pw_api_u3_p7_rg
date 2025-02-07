package uce.edu.web.api.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.to.EstudianteTo;

@Path("/estudiantes")
public class EstudianteController {

    @Inject
    private IEstudianteService iEstudianteService;

     @GET
     @Path("")
     public List<EstudianteTo> buscarTodos() {
         return this.iEstudianteService.buscarTodos();
    }

    @GET
    @Path("/porNombre")
    public List<EstudianteTo> buscarPorNombre(@QueryParam("nombre") String nombre) {
        return this.iEstudianteService.buscarPorNombre(nombre);
    }

    @GET
    @Path("/porNombreEdad")
    public List<EstudianteTo> buscarPorNombreEdad(@QueryParam("nombre") String nombre, @QueryParam("edad") Integer edad) {
        return this.iEstudianteService.buscarPorNombreEdad(nombre,edad);
    }
    
    @POST
    @Path("/guardar")
    public void guardar(EstudianteTo persona) {
        this.iEstudianteService.guardar(persona);
    }
    
    @PUT
    @Path("/actualizar")
    public void actualizar(EstudianteTo persona) {
        this.iEstudianteService.actualizar(persona);
    }

    @PATCH
    @Path("/actualizar/parcial")
    public void actualizarParcial(EstudianteTo persona) {
        EstudianteTo tmp = this.iEstudianteService.buscarPorId(persona.getId());
        tmp.setSemestre(persona.getSemestre());
        this.iEstudianteService.actualizar(tmp);
    }

    @DELETE
    @Path("/borrar")
    public void borrar(Integer id) {
        this.iEstudianteService.borrar(id);
    }

    
}
