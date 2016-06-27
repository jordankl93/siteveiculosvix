/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import src.model.Proposta;

/**
 *
 * @author Jordan-PC
 */
@ManagedBean(name = "faleConoscoBean")
@SessionScoped
public class FaleConoscoBean {
    private Proposta proposta;

    public Proposta getProposta() {
        return proposta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }
}
