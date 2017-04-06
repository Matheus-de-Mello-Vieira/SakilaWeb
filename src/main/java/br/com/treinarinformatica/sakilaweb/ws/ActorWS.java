/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakilaweb.ws;

import br.com.treinarinformatica.sakilaweb.model.Actor;
import br.com.treinarinformatica.sakilaweb.service.ActorService;
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
public class ActorWS {
    @EJB
    private ActorService actorService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Actor actor) {
        actorService.saveOrUpdate(actor);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer actorId) {
        actorService.delete(actorId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll() {
        GenericEntity<List<Actor>> entity = new GenericEntity<List<Actor>>(actorService.listAll()) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer actorId) {
        GenericEntity<Actor> entity = new GenericEntity<Actor>(actorService.findById(actorId)) {
        };
        return Response.ok(entity).build();
    }
}
