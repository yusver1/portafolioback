package com.portfolio.portfolioback.dto;

import javax.validation.constraints.NotBlank;

public class dtoHabilidadesBlandas {
    @NotBlank
    private String nombreHB;
    @NotBlank
    private String descripHB;

    public dtoHabilidadesBlandas() {
    }

    public dtoHabilidadesBlandas(String nombreHB, String descripHB) {
        this.nombreHB = nombreHB;
        this.descripHB = descripHB;
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
