/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakilaweb.service;


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
public class FilmService {
    @PersistenceContext
    private EntityManager em;
    
    public List<Film> listAll(){
        return em.createQuery("Select f from Film f order by f.id").getResultList();
    }
    public void saveOrUpdate(Film film){
        em.persist(film);
    }
            
}
