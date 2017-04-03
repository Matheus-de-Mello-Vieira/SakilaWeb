/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakilaweb.web;

import br.com.treinarinformatica.sakilaweb.model.Film;
import br.com.treinarinformatica.sakilaweb.service.FilmService;
import java.io.Serializable;
import static java.util.Collections.list;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ADM
 */
@Named
@ViewScoped
public class FilmBean implements Serializable {
   
    @EJB
    private FilmService filmService;
    private List<Film> filmList;
    @PostConstruct
    private void init(){
        setFilmList(getFilmService().listAll());
    }

    /**
     * @return the filmService
     */
    public FilmService getFilmService() {
        return filmService;
    }

    /**
     * @param filmService the filmService to set
     */
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    /**
     * @return the filmList
     */
    public List<Film> getFilmList() {
        return filmList;
    }

    /**
     * @param filmList the filmList to set
     */
    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
}

