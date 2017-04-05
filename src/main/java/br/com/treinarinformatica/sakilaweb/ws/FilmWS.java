/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakilaweb.ws;

import br.com.treinarinformatica.sakilaweb.model.Film;
import br.com.treinarinformatica.sakilaweb.service.FilmService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ADM
 */
@Path("/films")
public class FilmWS {
    @EJB
    private FilmService filmService;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Film film){
        filmService.saveOrUpdate(film);
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer filmId){
        filmService.delete(filmId);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll(){
        GenericEntity <List<Film>> entity=new GenericEntity <List<Film>>(filmService.listAll()){};
        return Response.ok(entity).build();
    }
    public void getById(){
        
    }
}
