package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PeronaController {

    @Inject
    private IPersonaService iPersonaService;

    @GET
    @Path("/buscar")
    public Response burcarPorId() {
        Integer id = 1;
        //return this.iPersonaService.burcarPorId(id);
        return Response.ok(this.iPersonaService.burcarPorId(id)).build();
    }

    
    public void actualizar(PersonaTo persona) {
        this.iPersonaService.actualizar(persona);

    }

    public void borrar(Integer id) {
        this.iPersonaService.borrar(id);

    }

    

    public void guardar(PersonaTo persona) {
        this.iPersonaService.guardar(persona);
    }

}
