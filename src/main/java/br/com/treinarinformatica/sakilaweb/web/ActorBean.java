/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakilaweb.web;

import br.com.treinarinformatica.sakilaweb.model.Actor;
import br.com.treinarinformatica.sakilaweb.service.ActorService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ADM
 */
@Named
@ViewScoped
public class ActorBean implements Serializable{
    @EJB
    private ActorService actorService;
    private List<Actor> actorList;
    
    /*
    * LIST, CREATE
     */
    private String currentState;

    private Actor actor;
    
    @PostConstruct
    private void init() {
        actorList=actorService.listAll();
        currentState = "LIST";
    }

    public void newFilm() {
        actor = new Actor();
        currentState = "CREATE";
    }

    public void save() {
        FacesMessage msg = null;
        try {
            actorService.saveOrUpdate(actor);
            actor = null;
            currentState = "LIST";
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved successfully", null);
            actorList = actorService.listAll();
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to save actor", null);
        }finally{
            if (msg != null) {
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }

    /**
     * @return the actorService
     */
    public ActorService getActorService() {
        return actorService;
    }

    /**
     * @param actorService the actorService to set
     */
    public void setActorService(ActorService actorService) {
        this.actorService = actorService;
    }

    /**
     * @return the actorList
     */
    public List<Actor> getActorList() {
        return actorList;
    }

    /**
     * @param actorList the actorList to set
     */
    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    /**
     * @return the currentState
     */
    public String getCurrentState() {
        return currentState;
    }

    /**
     * @param currentState the currentState to set
     */
    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    /**
     * @return the actor
     */
    public Actor getActor() {
        return actor;
    }

    /**
     * @param actor the actor to set
     */
    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
