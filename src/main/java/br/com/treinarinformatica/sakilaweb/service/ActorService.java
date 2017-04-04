/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakilaweb.service;

import br.com.treinarinformatica.sakilaweb.model.Actor;
import br.com.treinarinformatica.sakilaweb.model.Film;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ADM
 */
@Stateless
public class ActorService {
    @PersistenceContext
    private EntityManager em;
    
    public List<Actor> listAll(){
        return em.createQuery("Select c from actor c").getResultList();
    }
    public void saveOrUpdate(Actor actor){
        em.persist(actor);
    }   
}
