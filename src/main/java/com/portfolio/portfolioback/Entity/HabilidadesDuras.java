package com.portfolio.portfolioback.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabilidadesDuras {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHD;

    public HabilidadesDuras() {
    }

    public HabilidadesDuras(String nombreHD) {
        this.nombreHD = nombreHD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreHD() {
        return nombreHD;
    }

    public void setNombreHD(String nombreHD) {
        this.nombreHD = nombreHD;
    }    
    
}
