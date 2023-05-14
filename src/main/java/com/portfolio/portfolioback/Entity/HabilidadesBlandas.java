
package com.portfolio.portfolioback.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabilidadesBlandas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHB;
    private String descripHB;

    public HabilidadesBlandas() {
    }

    public HabilidadesBlandas(String nombreHB, String descripHB) {
        this.nombreHB = nombreHB;
        this.descripHB = descripHB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreHB() {
        return nombreHB;
    }

    public void setNombreHB(String nombreHB) {
        this.nombreHB = nombreHB;
    }

    public String getDescripHB() {
        return descripHB;
    }

    public void setDescripHB(String descripHB) {
        this.descripHB = descripHB;
    }   
    
}
