/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakilaweb.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ADM
 */
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="inventory_id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "film_id",referencedColumnName = "film_id")
    private Film film;
    
    @OneToMany(mappedBy = "rental")
    
    private List<Rental> rentalList;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the film
     */
    public Film getFilm() {
        return film;
    }

    /**
     * @param film the film to set
     */
    public void setFilm(Film film) {
        this.film = film;
    }


    /**
     * @return the rentalList
     */
    public List<Rental> getRentalList() {
        return rentalList;
    }

    /**
     * @param rentalList the rentalList to set
     */
    public void setRentalList(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }
    
    
}
