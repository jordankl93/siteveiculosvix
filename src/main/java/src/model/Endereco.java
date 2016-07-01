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
@Table(name = "endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 6837596734021991739L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idendereco")
    private Integer idEndereco;
    
    @Column(name = "rua", length = 45, nullable = false)
    private String rua;
    
    @Column(name = "cidade", length = 45, nullable = false)
    private String cidade;
    
    @Column(name = "cep", length = 45, nullable = true)
    private String cep;
    
    @Column(name = "estado", length = 2, nullable = true)
    private String estado;
    
    @Column(name = "pais", length = 45, nullable = false)
    private String pais;
    
    public Endereco(){
        
    }

    public Endereco(String rua, String cidade, String cep, String estado, String pais) {
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.pais = pais;
    }

    

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
