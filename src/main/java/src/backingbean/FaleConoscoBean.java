/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.backingbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import src.dao.PropostaDAO;
import src.model.Proposta;

/**
 *
 * @author Jordan-PC
 */
@ManagedBean(name = "faleConoscoBean")
@SessionScoped
public class FaleConoscoBean {

    private Proposta proposta;
    private PropostaDAO propostaDAO;

    public FaleConoscoBean() {
        this.proposta = new Proposta();
        this.propostaDAO = new PropostaDAO();
    }

    public Proposta getProposta() {
        return proposta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }

    //Envia uma proposta e returna pra página "Fale Conosco"
    public String enviaProposta(Proposta proposta) {
        if (propostaDAO.salvar(proposta)) {            
            novaProposta();
            addMessage("Mensagem enviada com sucesso");
        } else {
            addMessage("Desculpe, não foi possível enviar a mensagem! Tente contato via telefone.");
        }
        return "faleconosco";
    }
    
    /*Métodos utéis*/
    private void novaProposta() {
        proposta = new Proposta();
        proposta.setNomeCliente("");
        proposta.setTelefoneCliente("");
        proposta.setEmailCliente("");
        proposta.setMensegem("");
    }
    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
