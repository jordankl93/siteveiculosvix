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
@Table(name = "veiculo")
public class Veiculo implements Serializable { 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idveiculo")
    private Integer idVeiculo;
    
    @Column(name = "valor")
    private Double valor;
    
    @Column(name = "marca", length = 50, nullable = false)
    private String marca;
    
    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;
    
    @Column(name = "ano")
    private int ano;
    
    @Column(name = "opcionais", length = 200, nullable = false)
    private String opcionais;
    
    @Column(name = "extra", length = 200, nullable = false)
    private String extra;

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(String opcionais) {
        this.opcionais = opcionais;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    
}
