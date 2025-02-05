package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.to.EstudianteTo;

@Path("/estudiante")
public class EstudianteController {

    @Inject
    private IEstudianteService iEstudianteService;

     @GET
    @Path("/buscar")
    public EstudianteTo buscarPorId(Integer id) {
        return this.iEstudianteService.buscarPorId(id);
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
