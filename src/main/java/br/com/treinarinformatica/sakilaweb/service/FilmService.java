/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakilaweb.service;


import br.com.treinarinformatica.sakilaweb.model.Film;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public void delete(Integer filmId) {
        em.remove(em.find(Film.class, filmId));
    }
    public Film findById(Integer filmId){
        return em.find(Film.class, filmId);
    }        
    public Map<Integer,Integer> rentalCountPerFilm(){
        List<Object[]> list = em.createQuery("select f.id, count(*) from Rental r join r.inventory i join i.film f group by f.id").getResultList();
        Map<Integer, Integer> map= new HashMap<>();
        for(Object[] result : list){
            Integer filmId = (Integer) result[0];
            Integer rentalCount = (Integer) result[1];
            map.put(filmId, rentalCount);
        }
        return map;
    }
}
