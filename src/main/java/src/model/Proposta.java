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

    @ManyToOne
    @JoinColumn(name = "idveiculo")
    private Veiculo veiculo;

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
