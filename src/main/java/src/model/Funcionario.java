/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Briane
 */
import javax.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 7785640865115973784L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "nome", length = 200)
    private String nome;
    
    @Column(name = "login", length = 100)
    private String login;
    
    @Column(name = "senha", length = 45)
    private String senha;
    
    @Column(name = "email", length = 200, nullable = true)
    private String email;
    
    @Column(name = "IdEndereco")
    private int IdEndereco;

    public Integer getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public int getIdEndereco() {
        return IdEndereco;
    } 
  
}
