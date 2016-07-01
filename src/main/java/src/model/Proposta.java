/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Jordan-PC
 */
@Entity
@Table(name = "proposta")
public class Proposta implements Serializable {

    private static final long serialVersionUID = 6918394364279652430L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproposta")
    private Integer idProposta;

    @Column(name = "mensagem", length = 500, nullable = false)
    private String mensegem;

    @Column(name = "nomecliente", length = 60, nullable = false)
    private String nomeCliente;

    @Column(name = "emailcliente", length = 60, nullable = false)
    private String emailCliente;

    @Column(name = "telefonecliente", length = 30, nullable = false)
    private String telefoneCliente;

    @Column(name = "aceita", nullable = true)
    private boolean aceita;
    
    @ManyToOne
    @JoinColumn(name = "idveiculo")
    private Veiculo veiculo;

    public Proposta(String mensegem, String nomeCliente, String emailCliente, String telefoneCliente, Veiculo veiculo) {
        this.mensegem = mensegem;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.veiculo = veiculo;
    }

    public Proposta() {
       
    }

    public void Aceitar(boolean aceitou){
        if(this.veiculo == null){
            throw new UnsupportedOperationException("Não eh possivel aceitar a proposta pois o veiculo nao existe."); 
        }
        this.veiculo.Vender();
        this.aceita = aceitou;
    }
    
    public boolean Aceita(){
        if(this.aceita == true){
            return true;
        }else{
            return false;
        }
    }
    
    /*Get's e Set's*/
    public Integer getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(Integer idProposta) {
        this.idProposta = idProposta;
    }

    public String getMensegem() {
        return mensegem;
    }

    public void setMensegem(String mensegem) {
        this.mensegem = mensegem;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

}
