/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.*;

/**
 *
 * @author Jordan-PC
 */
@Entity
@Table(name = "loja")
public class Loja implements Serializable {

    private static final long serialVersionUID = -796273862557597024L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idloja")
    private Integer idLoja;
    
    @Column(name = "nome_fantasia", length = 60, nullable = false)
    private String nomeFantasia;
    
    @Column(name = "email", length = 90, nullable = false)
    private String email;
    
    @Column(name = "horario_inicial", nullable = false)
    private Time horarioInicial;
    
    @Column(name = "horario_final", nullable = false)
    private Time horarioFinal;
    
    @ManyToOne
    @JoinColumn(name = "idendereco")
    private Endereco endereco;

    public Integer getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Integer idLoja) {
        this.idLoja = idLoja;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Time getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(Time horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public Time getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Time horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
}
